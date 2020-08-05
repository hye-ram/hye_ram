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

	// 01. 로그인 체크
	@Override
	public boolean loginCheck(shopDTO dto, HttpSession session) {
		// TODO Auto-generated method stub
		boolean result = shopDao.loginCheck(dto);

		if (result == true) { 
			session.setAttribute("userId", dto.getUserId());
		}
			return result;
		
	}

	// 02. ȸ�� �α��� ����
	@Override

	public List<shopDTO> viewMember() throws Exception {
		return shopDao.viewMember();
	}
	public List<shopDTO> memInfo(String userId) {
		return shopDao.memInfo(userId);
	}
	// 03. ȸ�� �α׾ƿ�
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		shopDao.logout(session);
	}

	// 01. ���� ���̵� �ߺ� üũ
	@Override
	public int idCheck(String userId) {
		int result = shopDao.idCheck(userId);
		return result;
	}

	// 02. ����
	@Override
	public void signUp(shopDTO dto) {
		shopDao.signUp(dto);
	}


	@Override
	public int passCheck(shopDTO dto) {
		int result = shopDao.passCheck(dto);
		return result;
	}

	@Override
	public void secession(shopDTO dto, HttpSession session) {
		shopDao.secession(dto, session);
	}
}
