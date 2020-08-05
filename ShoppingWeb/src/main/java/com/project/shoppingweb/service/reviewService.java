package com.project.shoppingweb.service;

import java.util.List;
import com.project.shoppingweb.bean.reviewDTO;

public interface reviewService {

	//리뷰리스트
		public List<reviewDTO> reviewlistAll();
		//리뷰 글쓰기
		public void reviewcreate(reviewDTO dto) throws Exception;
		//리뷰보기
		public reviewDTO reviewread(int bno) throws Exception;
		//리뷰수정
		public void reviewupdate(reviewDTO dto) throws Exception;
		//리뷰 삭제
		public void reviewdelete(int bno) throws Exception;
		//리뷰 업데이트 페이지
		public reviewDTO review_updatego(int bno) throws Exception;
}
