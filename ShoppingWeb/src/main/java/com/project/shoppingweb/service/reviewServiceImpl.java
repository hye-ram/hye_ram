package com.project.shoppingweb.service;

import java.util.List;

import javax.inject.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.shoppingweb.dao.*;
import com.project.shoppingweb.bean.*;

@Service
public class reviewServiceImpl implements reviewService {

	@Inject
	reviewDAO reviewDao;

	// 리뷰게시판
	@Override
	public List<reviewDTO> reviewlistAll() {
		return reviewDao.reviewlistAll();
	}

	// 리뷰 글쓰기
	@Transactional // 트랜잭션 처리 메서드로 설정
	@Override
	public void reviewcreate(reviewDTO vo) throws Exception {
		/*
		 * String title = vo.getTitle(); String editor = vo.getEditor(); String writer =
		 * vo.getWriter();
		 * 
		 * title = title.replace("<", "&lt;"); title = title.replace("<", "&gt;");
		 * writer = writer.replace("<", "&lt;"); writer = writer.replace("<", "&gt;");
		 * title = title.replace("  ", "&nbsp;&nbsp;"); writer = writer.replace("  ",
		 * "&nbsp;&nbsp;"); editor = editor.replace("\n", "<br>");
		 * 
		 * System.out.println(editor); vo.setTitle(title); vo.setEditor(editor);
		 * vo.setWriter(writer);
		 */
		reviewDao.reviewcreate(vo);
		System.out.println("서비스임플" + vo);

	}

	// 리뷰 보기
	@Override
	public reviewDTO reviewread(int bno) throws Exception {
		return reviewDao.reviewread(bno);
	}

	// 리뷰 업데이트
	@Override
	public void reviewupdate(reviewDTO vo) throws Exception {
		reviewDao.reviewupdate(vo);
	}

	// 리뷰 삭제
	@Override
	public void reviewdelete(int bno) throws Exception {
		reviewDao.reviewdelete(bno);
	}

}
