package com.filproject.common.security.vo;

import java.io.Serializable;

public class UserVO implements Serializable{

	private static final long serialVersionUID = 2318848646884054384L;
	
	private String memId;
	private String memPw;
	private String auth;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
}
