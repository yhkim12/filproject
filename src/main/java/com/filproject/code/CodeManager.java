package com.filproject.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CodeManager {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static boolean isLoaded = false;
	
	private static List<CodeVO> domainCodeList = new ArrayList<CodeVO>();
	private static Map<String, CodeVO> domainCodeMap = new HashMap<String, CodeVO>();
	private static Map<String, List<CodeVO>> domainCodeMapList = new HashMap<String, List<CodeVO>>();

	@Autowired
	private CodeDao codeDao;
	
	@PostConstruct
	public void Init() {
		if (!isLoaded) {
			getCodeAll();
			isLoaded = true;
		}
	}
	
	/*코드 재로딩*/
	public void reload() {
		domainCodeList.clear();
		domainCodeMap.clear();
		domainCodeMapList.clear();
		getCodeAll();
	}
	
	/*모든 코드 조회*/
	private void getCodeAll() {
		try{
			if (logger.isInfoEnabled()) {
				logger.info("공통코드조회 시작");
			}
			
			domainCodeList = codeDao.selectAllCodeList();
			if (domainCodeList != null || domainCodeList.size() > 0) {
				for (int i = 0; i < domainCodeList.size(); i++) {
					CodeVO codeVO = (CodeVO)domainCodeList.get(i);
					domainCodeMap.put(codeVO.getCd(), codeVO);
					domainCodeMapList.put(codeVO.getCd(), codeVO.getSubCodeList());
					logger.info("상위코드=" + codeVO.getCd() + "/상위코드명=" + codeVO.getCdNm());
					for (int j=0; j < codeVO.getSubCodeList().size(); j++) {
						CodeVO subCodeVO = (CodeVO)codeVO.getSubCodeList().get(j);
						logger.info("코드=" + subCodeVO.getCd() + "/코드명=" + subCodeVO.getCdNm());
					}
				}
			}
			
			if (logger.isInfoEnabled()) {
				logger.info("공통 코드 조회 종료");
			}
		} catch (Exception e) {
			logger.error("", e);
		}
	}
	
	/**
	 * 해당 도메인 코드 + 해당 코드의 상세 정보를 반환
	 * @param domainCode 도메인코드
	 * @param code 코드
	 * @return
	 * @throws Exception
	 */
	public static CodeVO getCode(String domainCode, String code) throws Exception {
		CodeVO dCode = (CodeVO)domainCodeMap.get(domainCode);
		List sCodeList = dCode.getSubCodeList();

        if (sCodeList == null || sCodeList.size() == 0 ) {
            return null;
        }

        CodeVO sCode = null;
        for (int i = 0; i < sCodeList.size(); i++) {
        	CodeVO _code = (CodeVO)sCodeList.get(i);
        	if (code.equals(_code.getCd())) {
                sCode = _code;
                break;
            }
        }

        return sCode;
	}

	/**
	 * 해당 도메인 코드 + 해당 코드의 코드명을 반환
	 * @param domainCode 도메인코드
	 * @param code 코드
	 * @return
	 * @throws Exception
	 */
	public static String getCodeNm(String domainCode, String code) throws Exception {
		CodeVO sCode = getCode(domainCode, code);
		if (sCode == null)
			return "";
		return sCode.getCdNm();
	}

	/**
	 * 해당 도메인 코드의 하위 코드들을 반환
	 * @param domainCode 도메인코드
	 * @return
	 * @throws Exception
	 */
	public static List<CodeVO> getSubCodeList(String domainCode) throws Exception {
		CodeVO dCode = (CodeVO)domainCodeMap.get(domainCode);
		if (dCode == null)
			return null;
		return dCode.getSubCodeList();
	}

	/**
	 * 해당 도메인 코드의 하위 코드들을 <코드, 코드명> 형식으로 반환
	 * @param domainCode 도메인코드
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> getSubCodeMap(String domainCode) throws Exception {
		Map<String, String> sCodeMap = new TreeMap<String, String>();
		List<CodeVO> sCodeList = getSubCodeList(domainCode);
		for (int i = 0; i < sCodeList.size(); i++) {
			CodeVO code = sCodeList.get(i);
			sCodeMap.put(code.getCd(), code.getCdNm());
        }
		return sCodeMap;
	}

	/**
	 * 도메인 코드 리스트를 반환
	 * @return
	 */
	public static List<CodeVO> getDomainCodeList() {
		return domainCodeList;
	}

	/**
	 * 전체 코드를 <도메인 코드명 : 코드 객체> 형식으로 반환
	 * @return
	 */
	public static Map<String, CodeVO> getDomainCodeMap() {
		return domainCodeMap;
	}

	/**
	 * 전체 코드를 <도메인 코드명 : 하위 코드 리스트> 형식으로 반환
	 * 
	 * @return
	 */
	public static Map<String, List<CodeVO>> getDomainCodeMapList() {
		return domainCodeMapList;
	}
}
