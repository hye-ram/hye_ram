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

	// 01. ȸ�� �α��� üũ
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

	// 01. �Խñ� �ۼ�
	@Override
	public void create(boardDTO vo) throws Exception {
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		shopDao.create(vo);
	}

	// 02. �Խñ� �󼼺���
	@Override
	public boardDTO read(int bno) throws Exception {
		return shopDao.read(bno);
	}

	// 03. �Խñ� ����
	@Override
	public void update(boardDTO vo) throws Exception {
		shopDao.update(vo);
	}

	// 04. �Խñ� ����
	@Override
	public void delete(int bno) throws Exception {
		shopDao.delete(bno);
	}

	// 05. �Խñ� ��ü ���
	@Override
	public List<boardDTO> listAll() {
		return shopDao.listAll();
	}

	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub

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
