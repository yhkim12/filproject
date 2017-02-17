package com.filproject.code;

import java.util.List;

public class CodeVO {
	
	private int seq;
	private String cd; 
	private String upCd; 
	private String cdNm; 
	private int level; 
	private int ord;
	
	private List<CodeVO> subCodeList;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getUpCd() {
		return upCd;
	}
	public void setUpCd(String upCd) {
		this.upCd = upCd;
	}
	public String getCdNm() {
		return cdNm;
	}
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public List<CodeVO> getSubCodeList() {
		return subCodeList;
	}
	public void setSubCodeList(List<CodeVO> subCodeList) {
		this.subCodeList = subCodeList;
	}
	public int getOrd() {
		return ord;
	}
	public void setOrd(int ord) {
		this.ord = ord;
	}
	

}
