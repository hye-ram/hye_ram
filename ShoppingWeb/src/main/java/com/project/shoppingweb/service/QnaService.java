package com.project.shoppingweb.service;

import java.util.List;
import com.project.shoppingweb.bean.qnaDTO;

public interface QnaService {

	// 리뷰리스트
	public List<qnaDTO> qnalistAll();

	// 리뷰 글쓰기
	public void qnacreate(qnaDTO dto) throws Exception;

	// 리뷰보기
	public qnaDTO qnaread(int bno) throws Exception;

	// 리뷰 업데이트 페이지 보기
	public qnaDTO qna_updatego(int bno) throws Exception;

	// 리뷰수정
	public void qnaupdate(qnaDTO dto) throws Exception;

	// 리뷰 삭제
	public void qnadelete(int bno) throws Exception;

	// 제품상세페이지 리뷰
	List<qnaDTO> qna_product(int product_id);

}
