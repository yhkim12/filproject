
package com.filproject.user.member.service;

import java.util.Map;

/**
 * 회원 관련 서비스
 * @author dev-jjong
 *
 */
public interface MemberService {

	Map<String, Object> loginAjax(Map<String, Object> map) throws Exception;

}
