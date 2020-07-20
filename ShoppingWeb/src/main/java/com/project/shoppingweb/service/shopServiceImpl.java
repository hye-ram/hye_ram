package com.project.shoppingweb.service;

import java.util.List;

import javax.inject.*;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import com.project.shoppingweb.dao.*;
import com.project.shoppingweb.bean.*;

@Service 
public class shopServiceImpl implements shopService {
	
	@Inject
	shopDAO shopDao;
	

	  
		/*
		 * // 01. 회원 로그인 체크
		 * 
		 * @Override public boolean loginCheck(shopDTO dto, HttpSession session) {
		 * boolean result = shopDao.loginCheck(dto); if (result == true) { //true 일경우 세션
		 * 등록 //세션 변수 등록 session.setAttribute("userId",dto.getUserID()); } return
		 * result; }
		 * 
		 * // 02. 회원 로그인 정보
		 * 
		 * @Override public shopDTO viewMember(shopDTO dto) { // TODO Auto-generated
		 * method stub return shopDao.viewMember(dto); }
		 * 
		 * // 03. 회원 로그아웃
		 * 
		 * @Override public void logout(HttpSession session) { // TODO Auto-generated
		 * method stub // 세션 변수 개별 삭제 // session.removeAttribute("userId"); // 세션 정보를
		 * 초기화 시킴 //session.invalidate(); shopDao.logout(session); }
		 * 
		 */

	@Override
	public boolean loginCheck(shopDTO dto, HttpSession session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public shopDTO viewMember(shopDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(shopDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public shopDTO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(shopDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<shopDTO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
