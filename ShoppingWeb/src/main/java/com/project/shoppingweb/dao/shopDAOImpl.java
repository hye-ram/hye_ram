package com.project.shoppingweb.dao;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.shoppingweb.bean.*;

@Repository
public class shopDAOImpl implements shopDAO {

	@Inject
	private SqlSession sqlSession;

	// 01. 로그인 체크
	@Override
	public boolean loginCheck(shopDTO dto) {
		String name = sqlSession.selectOne("member.loginCheck", dto);
		return (Integer.parseInt(name) == 0) ? false : true;
	}

	// 02. 회원 정보 조회
	@Override
	public List<shopDTO> memInfo(String userId) {
		return sqlSession.selectList("member.memInfo", userId);
	}

	// 03. 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	// 01. 아이디 중복 체크
	@Override
	public int idCheck(String userId) {
		int result = sqlSession.selectOne("member.idCheck", userId);
		return result;
	}

	// 02. 회원가입
	@Override
	public void signUp(shopDTO dto) {
		sqlSession.insert("member.signUp", dto);
	}

	// 01. �Խñ� �ۼ�
	@Override
	public void create(boardDTO dto) throws Exception {
		sqlSession.insert("board.insert", dto);
	}

	// 02. �Խñ� �󼼺���
	@Override
	public boardDTO read(int bno) throws Exception {
		return sqlSession.selectOne("board.view", bno);
	}

	// 03. �Խñ� ����
	@Override
	public void update(boardDTO dto) throws Exception {
		sqlSession.update("board.updateArticle", dto);
	}

	// 04. �Խñ� ����
	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.deleteArticle", bno);
	}

	// 05. �Խñ� ��ü ���
	@Override
	public List<boardDTO> listAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.listAll");
	}

	// 06. �Խñ� ��ȸ
	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub

	}

	// 패스워드 체크
	public int passCheck(shopDTO dto) {
		int result = Integer.parseInt((String) sqlSession.selectOne("member.loginCheck", dto));
		return result;
	}

	// 회원탈퇴
	public void secession(shopDTO dto, HttpSession session) {
		sqlSession.delete("member.secession", dto);
		// 세션 삭제
		session.invalidate();
	}

}
