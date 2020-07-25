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
		if (result == true) { // true �ϰ�� ���� ���
			// ���� ���� ���
			session.setAttribute("userId", dto.getUserId());
		}
		return result;
	}

	// 02. ȸ�� �α��� ����
	@Override
	public List<shopDTO> viewMember() throws Exception {
		return shopDao.listAll();
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
	public void create(shopDTO vo) throws Exception {
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		// *?��그문?�� 처리 (< ==> &lt; > ==> &gt;)
		// replace(A, B) A�? B�? �?�?
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace("<", "&gt;");
		// *공백문자 처리
		title = title.replace("  ", "&nbsp;&nbsp;");
		writer = writer.replace("  ", "&nbsp;&nbsp;");
		// *줄바�? 문자처리
		content = content.replace("\n", "<br>");
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		shopDao.create(vo);
	}

	// 02. �Խñ� �󼼺���
	@Override
	public shopDTO read(int bno) throws Exception {
		return shopDao.read(bno);
	}

	// 03. �Խñ� ����
	@Override
	public void update(shopDTO vo) throws Exception {
		shopDao.update(vo);
	}

	// 04. �Խñ� ����
	@Override
	public void delete(int bno) throws Exception {
		shopDao.delete(bno);
	}

	// 05. �Խñ� ��ü ���
	@Override
	public List<shopDTO> listAll() {
		return shopDao.listAll();
	}

	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub

	}

}
