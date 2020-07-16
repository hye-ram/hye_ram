package com.project.shoppingweb.dao;

import javax.servlet.http.HttpSession;
import com.project.shoppingweb.bean.*;

public interface shopDAO {
	// 01. 회원 로그인 체크
	public boolean loginCheck(shopDTO dto);
	// 02. 회원 로그인 정보
	public shopDTO viewMember(shopDTO dto);
	// 03. 회원 로그아웃
	public void logout(HttpSession session);
	

}
