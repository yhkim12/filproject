package com.filproject.user.member.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.filproject.user.member.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Resource(name = "MemberDao")
	private MemberDao memberDao;
	
	  @Override
	   public Model memSelect(Model model, Map<String, Object> paramMap){
	      Map<String,Object> map = memberDao.memSelect(paramMap); 

	      return model;
	   }
	
	
	@Override
	public Map<String, Object> memInsert(Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int resultYn = memberDao.memInsert(paramMap);
		if (resultYn == 0) {
			map.put("resultYn", "N");
		}else {
			map.put("resultYn", "Y");
		}
		return map;
	}
	
	@Override
	public Map<String, Object> memUpdate(Map<String, Object> paramMap) {
		
		memberDao.memUpdate(paramMap);
		
		return paramMap;

	}
	
	@Override
	public Map<String, Object> memDelete(Map<String, Object> paramMap) {
		
		memberDao.memDelete(paramMap);
		
		return paramMap;
	}
	
   @Override
   public Map<String, Object> checkId(Map<String, Object> paramMap) {
         
      Map<String, Object> resultMap = memberDao.checkId(paramMap);
      
      if(resultMap == null){ 
         
         resultMap = new HashMap<String, Object>();
         resultMap.put("state", false ); 
         
      } else {
         
         resultMap.put("state", true ); 
      }
         
      return resultMap;
   }
   
   @Override
   public Map<String, Object> memSearch(Map<String, Object> paramMap) {
	   
	   Map<String, Object> resultMap = memberDao.memSearch(paramMap);
	   
	   if(resultMap == null){ 
		   
		   resultMap = new HashMap<String, Object>(); 
		   resultMap.put("state", false );
		   
	   } else {
		   
		   resultMap.put("state", true ); 
	   }
	   
	   return resultMap; 
   }
   
   
   @Override
   public Map<String, Object> login(Map<String, Object> paramMap, HttpSession session) {
         
      Map<String, Object> resultMap = memberDao.checkId(paramMap);
      
      if(resultMap == null){ 
         
         resultMap = new HashMap<String, Object>(); 
         resultMap.put("state", false );
         
      } else {
         
         resultMap.put("state", true ); 
         session.setAttribute("sId", resultMap.get("MEM_ID") ); 
         session.setAttribute("sIdx", resultMap.get("MEM_IDX") );
         }
         
      return resultMap; 
   }

}
