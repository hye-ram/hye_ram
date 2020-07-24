package com.project.shoppingweb.bean;

public class shopDTO {
	private String userID;
	private String userPW;
	private String userName;
	private String userEmail;
	private int bno; // 게시글 번호
	private String title; // 게시글 제목
	private String content; // 게시글 내용
	private String writer; // 게시글 작성자
	private String regdate; // 게시글 작성일자 util.Date

	private int viewcnt; // 게시글 조회수

	/*
	 * @Override public String toString() { return "LoginVO [userId=" + userID +
	 * ", passwd=" + userPW + "]"; }
	 */
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	// toString()
	@Override
	public String toString() {
		return "shopDTO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate /* + ", viewcnt=" + viewcnt */ + "]";
	}

}
