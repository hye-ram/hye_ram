package com.project.shoppingweb.bean;

public class boardDTO {

	private int bno; // �� ��ȣ
	private String title; // �� ����
	private String content; // �� ����
	private String writer; // �۾���
	private String regdate; // �۾� ��¥

	private int viewcnt; // ��ȸ��

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
	  
	  @Override public String toString() { return "shopDTO [bno=" + bno +
	  ", title=" + title + ", content=" + content + ", writer=" + writer +
	  ", regdate=" + regdate + ", viewcnt=" + viewcnt + "]"; }
	 

}
