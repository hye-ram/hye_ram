package com.project.shoppingweb.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.shoppingweb.bean.reviewDTO;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.shoppingweb.bean.*;
@Repository
public class reviewDAOImpl implements reviewDAO {

	@Inject
	private SqlSession sqlSession;
	
	
	//리뷰게시판
	@Override
	public List<reviewDTO> reviewlistAll() {
		// TODO Auto-generated method stub
		 return sqlSession.selectList("review.reviewlistAll");
	}
	//리뷰글쓰기
	@Override
	public void reviewcreate(reviewDTO dto) throws Exception {
		sqlSession.insert("review.reinsert", dto);
		System.out.println("dao"+dto);
	}
	//리뷰 읽기
	@Override
	public reviewDTO reviewread(int bno) throws Exception {
		 return sqlSession.selectOne("review.view", bno);
	}
	//리뷰 업뎃
	@Override
	public void reviewupdate(reviewDTO dto) throws Exception {
		sqlSession.update("review.updateArticle", dto);
	}
	//리뷰 삭제
	@Override
	public void reviewdelete(int bno) throws Exception {
		sqlSession.delete("review.deleteArticle",bno);
	}
}
