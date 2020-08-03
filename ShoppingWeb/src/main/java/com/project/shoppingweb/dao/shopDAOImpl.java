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


	@Override

	public List<shopDTO> viewMember() throws Exception {
		return sqlSession.selectList("testMapper.listAll");
    }
	// 03. ȸ�� �α׾ƿ�

	public List<shopDTO> memInfo(String userId) {
		return sqlSession.selectList("member.memInfo", userId);
	}

	// 03. 로그아웃

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}


	@Override
	public int idCheck(String userId) {
		int result = sqlSession.selectOne("member.idCheck", userId);
		return result;
	}

	// 02. 회원가입

	@Override
	public void signUp(shopDTO dto) {

		System.out.println("ȸ������");
		sqlSession.insert("memberMapper.signUp", dto);

		sqlSession.insert("member.signUp", dto);

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
