package com.project.shoppingweb.dao;

import java.util.List;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Repository;
import com.project.shoppingweb.bean.*;

@Repository
public interface boardDAO {
	// 게시판 글쓰기
		public void create(boardDTO dto) throws Exception;
		//게시판 읽기
		public boardDTO read(int bno) throws Exception;
		//게시판 업뎃
		public void update(boardDTO dto) throws Exception;
		// 게시판 삭제
		public void delete(int bno) throws Exception;
		// 게시판 리스트
		public List<boardDTO> listAll();
}
