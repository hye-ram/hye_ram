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

	@Override
	public boolean loginCheck(shopDTO dto, HttpSession session) {
		// TODO Auto-generated method stub
		
		boolean result = shopDao.loginCheck(dto);
		if (result == true) {	//true 일경우 세션 등록
			//세션 변수 등록
			session.setAttribute("userId",dto.getUserId());
		}
		return result;
	}

	@Override
	public List<shopDTO> viewMember() throws Exception {
        return shopDao.listAll();
    }

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		shopDao.logout(session);
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
	public List<shopDTO> listAll() {
		// TODO Auto-generated method stub
		return shopDao.listAll();
	}

	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	// 01. 가입 아이디 중복 체크
	@Override
	public int idCheck(String userId) {
		int result = shopDao.idCheck(userId);
		return result;
	}
	// 02. 가입 
	@Override
	public void signUp(shopDTO dto) {
		shopDao.signUp(dto);
	}

}
