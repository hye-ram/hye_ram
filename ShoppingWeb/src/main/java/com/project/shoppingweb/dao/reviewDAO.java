package com.project.shoppingweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.shoppingweb.bean.reviewDTO;

@Repository
public interface reviewDAO {

	// 리뷰 리스트
	public List<reviewDTO> reviewlistAll();

	// 리뷰 글쓰기
	public void reviewcreate(reviewDTO dto) throws Exception;

	// 리뷰보기
	public reviewDTO reviewread(int bno) throws Exception;

	// 리뷰 업뎃 페이지 보기
	public reviewDTO review_updatego(int bno) throws Exception;

	// 리뷰 업뎃
	public void reviewupdate(reviewDTO dto) throws Exception;

	// 리뷰 삭제
	public void reviewdelete(int bno) throws Exception;

	// 홈페이지 리뷰
	List<reviewDTO> readReview();

	public List<reviewDTO> review_product(int product_id);

}
