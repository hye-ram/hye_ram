package com.project.shoppingweb.dao;

import javax.servlet.http.HttpSession;
//import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.shoppingweb.bean.*;

public interface shopDAO {
	
	//@Autowired
	//SqlSession sqlSession;
	
	
	// 01. 회원 로그인 체크
	/*
	 * public boolean loginCheck(shopDTO dto) {
	 * System.out.println("===> Mybatis로 loginCheck() 기능 처리"); String name =
	 * sqlSession.selectOne("memberMapper.loginCheck",vo);
	 * 
	 * // 검색이 안되면 0을 반환해주기 때문에 0과 비교해서 참이면 false, 틀리면 true를 반환 return
	 * (Integer.parseInt(name)==0)?false:true; }
	 * 
	 * // 02. 회원 로그인 정보 public shopDTO viewMember(shopDTO dto); // 03. 회원 로그아웃
	 * public void logout(HttpSession session) {
	 * System.out.println("===> 로그아웃 기능 처리"); session.invalidate(); }
	 */
	
	

}
