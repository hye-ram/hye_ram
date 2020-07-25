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

	// 01. 회원 로그인 체크
	@Override
	public boolean loginCheck(shopDTO dto, HttpSession session) {
		// TODO Auto-generated method stub

		boolean result = shopDao.loginCheck(dto);
		if (result == true) { // true 일경우 세션 등록
			// 세션 변수 등록
			session.setAttribute("userId", dto.getUserId());
		}
		return result;
	}

	// 02. 회원 로그인 정보
	@Override
	public List<shopDTO> viewMember() throws Exception {
		return shopDao.listAll();
	}

	// 03. 회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		shopDao.logout(session);
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

	// 01. 게시글 작성
	@Override
	public void create(shopDTO vo) throws Exception {
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		// *?깭洹몃Ц?옄 泥섎━ (< ==> &lt; > ==> &gt;)
		// replace(A, B) A瑜? B濡? 蹂?寃?
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace("<", "&gt;");
		// *怨듬갚臾몄옄 泥섎━
		title = title.replace("  ", "&nbsp;&nbsp;");
		writer = writer.replace("  ", "&nbsp;&nbsp;");
		// *以꾨컮轅? 臾몄옄泥섎━
		content = content.replace("\n", "<br>");
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		shopDao.create(vo);
	}

	// 02. 게시글 상세보기
	@Override
	public shopDTO read(int bno) throws Exception {
		return shopDao.read(bno);
	}

	// 03. 게시글 수정
	@Override
	public void update(shopDTO vo) throws Exception {
		shopDao.update(vo);
	}

	// 04. 게시글 삭제
	@Override
	public void delete(int bno) throws Exception {
		shopDao.delete(bno);
	}

	// 05. 게시글 전체 목록
	@Override
	public List<shopDTO> listAll() {
		return shopDao.listAll();
	}

	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub

	}

}
