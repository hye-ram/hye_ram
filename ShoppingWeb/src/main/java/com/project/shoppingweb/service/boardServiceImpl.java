package com.project.shoppingweb.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.shoppingweb.dao.*;
import com.project.shoppingweb.bean.*;

@Service
public class boardServiceImpl implements boardService{
	
	@Inject
	boardDAO boardDao;
	
	// 게시판 리스트
	@Override
	public List<boardDTO> listAll() {
		return boardDao.listAll();
	}
	
	//게시판 글쓰기
	@Transactional // 트랜잭션 처리 메서드로 설정
	@Override
	public void create(boardDTO vo) throws Exception {
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		// *?��그문?�� 처리 (< ==> &lt; > ==> &gt;)
		// replace(A, B) A�? B�? �?�?
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace("<", "&gt;");
		// *공백문자 처리
		title = title.replace("  ", "&nbsp;&nbsp;");
		writer = writer.replace("  ", "&nbsp;&nbsp;");
		// *줄바�? 문자처리
		content = content.replace("\n", "<br>");
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		boardDao.create(vo);
	}
	//게시판 보기
		@Override
		public boardDTO read(int bno) throws Exception {
			return boardDao.read(bno);
		}

		//게시판 업뎃
		@Override
		public void update(boardDTO vo) throws Exception {
			boardDao.update(vo);
		}

		//게시판 삭제
		@Override
		public void delete(int bno) throws Exception {
			boardDao.delete(bno);
		}


}
