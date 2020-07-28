package com.project.shoppingweb.bean;

import java.awt.List;
import java.sql.Date;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class reviewDTO {
	private int bno; 
	private String title; 
	private String editor; 
	private String writer; 
	private Date regdate;


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
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "reviewDTO [bno=" + bno + ", title=" + title + ", editor=" + editor + ", writer=" + writer + ", regdate="
				+ regdate + "]";
	}
	
}
