package com.project.shoppingweb.service;

import java.util.List;
import com.project.shoppingweb.bean.boardDTO;
import com.project.shoppingweb.bean.reviewDTO;

public interface boardService {

	// 게시판 글쓰기
	public void create(boardDTO dto) throws Exception;

	// 게시판 보기
	public boardDTO read(int bno) throws Exception;

	// 리뷰 업데이트 페이지 보기
	public boardDTO notice_updatego(int bno) throws Exception;

	// 게시판 업뎃
	public void update(boardDTO dto) throws Exception;

	// 게시판 삭제
	public void delete(int bno) throws Exception;

	// 게시판 리스트
	public List<boardDTO> listAll();

}
