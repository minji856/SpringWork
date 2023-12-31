package com.exam.domain;

public class Board {
	private int bNo;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String bRegdate;
	private int bViewcnt;
	
//	테스트코드를 위해 생성자 생성
	public Board(String bTitle, String bContent, String bWriter) {
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
	}
	
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbRegdate() {
		return bRegdate;
	}
	public void setbRegdate(String bRegdate) {
		this.bRegdate = bRegdate;
	}
	public int getbViewcnt() {
		return bViewcnt;
	}
	public void setbViewcnt(int bViewcnt) {
		this.bViewcnt = bViewcnt;
	}
}
