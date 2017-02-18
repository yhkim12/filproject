package com.filproject.user.member.service.impl;

import java.util.HashMap;
import java.util.Map;
import com.filproject.admin.common.CommonUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filproject.user.member.dao.MemberDao;
import com.filproject.user.member.service.MemberService;

/**
 * 회원 관련 서비스 임플
 * @author dev-jjong
 *
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Map<String, Object> loginAjax(Map<String, Object> map) throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String pw = (String) map.get("memPw");
		if (StringUtils.isEmpty(pw)) {
			throw new Exception("비밀번호 없음");
		}
		
		map.put("memPw", CommonUtil.setSHA256(pw));
		int cnt = memberDao.selectMemberCnt(map);
		if (cnt == 1) {
			resultMap.put("success", "Y");
		} else {
			resultMap.put("success", "N");
		}
		return resultMap;
	}
}
