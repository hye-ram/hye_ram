package com.project.shoppingweb.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.shoppingweb.bean.*;



@Repository
public interface shopDAO {

	// 01. 회원 로그인 체크
	public boolean loginCheck(shopDTO dto);
	// 02. 회원 로그인 정보
	public shopDTO viewMember(shopDTO dto);
	// 03. 회원 로그아웃
	public void logout(HttpSession session);
	 
	// 01. 게시글 작성
	public void create(shopDTO dto) throws Exception;
	// 02. 게시글 상세보기
	public shopDTO read(int bno) throws Exception;
	// 03. 게시글 수정
	public void update(shopDTO dto) throws Exception;
	// 04. 게시글 삭제
	public void delete(int bno) throws Exception;
	// 05. 게시글 전체 목록
	public List<shopDTO> listAll() throws Exception;
	// 06. 게시글 조회
	public void increaseViewcnt(int bno, HttpSession session) throws Exception;
}
