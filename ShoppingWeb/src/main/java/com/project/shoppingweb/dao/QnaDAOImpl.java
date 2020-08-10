package com.project.shoppingweb.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.shoppingweb.bean.qnaDTO;

@Repository
public class QnaDAOImpl implements QnaDAO {

	@Inject
	private SqlSession sqlSession;

	// 리뷰게시판
	@Override
	public List<qnaDTO> qnalistAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("qna.qnalistAll");
	}

	// 리뷰글쓰기
	@Override
	public void qnacreate(qnaDTO dto) throws Exception {
		sqlSession.insert("qna.qnainsert", dto);
	}

	// 리뷰 읽기
	@Override
	public qnaDTO qnaread(int bno) throws Exception {
		return sqlSession.selectOne("qna.view", bno);
	}

	// 리뷰 업뎃페이지 보기
	@Override
	public qnaDTO qna_updatego(int bno) throws Exception {
		return sqlSession.selectOne("qna.update", bno);
	}

	// 리뷰 업뎃
	@Override
	public void qnaupdate(qnaDTO dto) throws Exception {
		sqlSession.update("qna.updateArticle", dto);
	}

	// 리뷰 삭제
	@Override
	public void qnadelete(int bno) throws Exception {
		sqlSession.delete("qna.deleteArticle", bno);
	}

	@Override
	public List<qnaDTO> qna_product(int product_id) {
		return sqlSession.selectList("qna.qna_product", product_id);
	}
}
