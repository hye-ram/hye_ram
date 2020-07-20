package com.project.shoppingweb.service;

import java.util.List;

import javax.inject.*;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import com.project.shoppingweb.dao.*;
import com.project.shoppingweb.bean.*;

@Service //���� Ŭ������ ���������� �����ϴ� service bean���� ���
public class shopServiceImpl implements shopService {
	
	@Inject
	shopDAO shopDao;
	

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

	/*
	 * // 01. ȸ�� �α��� üũ
	 * 
	 * @Override public boolean loginCheck(shopDTO dto, HttpSession session) {
	 * boolean result = shopDao.loginCheck(dto); if (result == true) { //true �ϰ�� ����
	 * ��� //���� ���� ��� session.setAttribute("userId",dto.getUserID()); } return
	 * result; } // 02. ȸ�� �α��� ����
	 * 
	 * @Override public shopDTO viewMember(shopDTO dto) { // TODO Auto-generated
	 * method stub return shopDao.viewMember(dto); } // 03. ȸ�� �α׾ƿ�
	 * 
	 * @Override public void logout(HttpSession session) { // TODO Auto-generated
	 * method stub // ���� ���� ���� ���� // session.removeAttribute("userId"); // ���� ������
	 * �ʱ�ȭ ��Ŵ //session.invalidate(); shopDao.logout(session); }
	 */
}
