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
		String name = sqlSession.selectOne("memberMapper.loginCheck",dto);
		// 검색이 안되면 0을 반환해주기 때문에 0과 비교해서 참이면 false, 틀리면 true를 반환
		return (Integer.parseInt(name)==0)?false:true;
	}
	// 02. 회원 로그인 정보
	@Override
	public List<shopDTO> viewMember() throws Exception {
		return sqlSession.selectList("testMapper.listAll");
    }
	// 03. 회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	
	// 01. 가입 아이디 중복 체크
	@Override
	public int idCheck(String userId) {
		int result = sqlSession.selectOne("memberMapper.idCheck", userId);
		return result;
	}
	// 02. 가입
	@Override
	public void signUp(shopDTO dto) {
		System.out.println("회원가입");
		sqlSession.insert("memberMapper.signUp", dto);
	}
	// 01. 게시글 작성
	@Override
	public void create(shopDTO dto) throws Exception {
		sqlSession.insert("board.insert", dto);
	}
	// 02. 게시글 상세보기
	@Override
	public shopDTO read(int bno) throws Exception {
		 return sqlSession.selectOne("board.view", bno);
	}
	// 03. 게시글 수정
	@Override
	public void update(shopDTO dto) throws Exception {
		sqlSession.update("board.updateArticle", dto);
	}
	// 04. 게시글 삭제
	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.deleteArticle",bno);
	}
	// 05. 게시글 전체 목록
	@Override
	public List<shopDTO> listAll() {
		// TODO Auto-generated method stub
		 return sqlSession.selectList("board.listAll");
	}
	// 06. 게시글 조회
	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}


	
	
