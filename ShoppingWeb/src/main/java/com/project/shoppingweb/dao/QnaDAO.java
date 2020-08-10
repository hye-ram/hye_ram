package com.project.shoppingweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.shoppingweb.bean.qnaDTO;

@Repository
public interface QnaDAO {

	// 리뷰 리스트
	public List<qnaDTO> qnalistAll();

	// 리뷰 글쓰기
	public void qnacreate(qnaDTO dto) throws Exception;

	// 리뷰보기
	public qnaDTO qnaread(int bno) throws Exception;

	// 리뷰 업뎃 페이지 보기
	public qnaDTO qna_updatego(int bno) throws Exception;

	// 리뷰 업뎃
	public void qnaupdate(qnaDTO dto) throws Exception;

	// 리뷰 삭제
	public void qnadelete(int bno) throws Exception;

	public List<qnaDTO> qna_product(int product_id);

}
