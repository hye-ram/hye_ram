package com.project.shoppingweb.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.shoppingweb.bean.boardDTO;

@Repository
public class boardDAOImpl implements boardDAO{

	@Inject
	private SqlSession sqlSession;
	
	//게시판 글쓰기
		@Override
		public void create(boardDTO dto) throws Exception {
			sqlSession.insert("board.insert", dto);
		}
		// 게시판 보기
		@Override
		public boardDTO read(int bno) throws Exception {
			 return sqlSession.selectOne("board.view", bno);
		}
		//게시판 업뎃
		@Override
		public void update(boardDTO dto) throws Exception {
			sqlSession.update("board.updateArticle", dto);
		}
		//게시판 삭제
		@Override
		public void delete(int bno) throws Exception {
			sqlSession.delete("board.deleteArticle",bno);
		}
		// 게시판 리스트
		@Override
		public List<boardDTO> listAll() {
			// TODO Auto-generated method stub
			 return sqlSession.selectList("board.listAll");
		}
}
