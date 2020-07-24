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
	
	@Override
	public boolean loginCheck(shopDTO dto) {
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

	 // 01. 게시글 작성
    @Override
    public void create(shopDTO vo) throws Exception {
    	sqlSession.insert("board.insert", vo);
    }
    // 02. 게시글 상세보기
    @Override
    public shopDTO read(int bno) throws Exception {
        return sqlSession.selectOne("board.view", bno);
    }
    // 03. 게시글 수정
    @Override
    public void update(shopDTO vo) throws Exception {
    	sqlSession.update("board.updateArticle", vo);
 
    }
    // 04. 게시글 삭제
    @Override
    public void delete(int bno) throws Exception {
    	sqlSession.delete("board.deleteArticle",bno);
 
    }
    // 05. 게시글 전체 목록
    @Override
    public List<shopDTO> listAll() throws Exception {
        return sqlSession.selectList("board.listAll");
    }
    // 게시글 조회수 증가
	/*
	 * @Override public void increaseViewcnt(int bno) throws Exception {
	 * SqlSession.update("board.increaseViewcnt", bno); }
	 */
}


	
	
