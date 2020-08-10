package com.project.shoppingweb.service;

import java.util.List;

import javax.inject.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.shoppingweb.dao.*;
import com.project.shoppingweb.bean.qnaDTO;

@Service
public class QnaServiceImpl implements QnaService {

	@Inject
	QnaDAO qnaDao;

	// 리뷰게시판
	@Override
	public List<qnaDTO> qnalistAll() {
		return qnaDao.qnalistAll();
	}

	// 리뷰 글쓰기
	@Transactional // 트랜잭션 처리 메서드로 설정
	@Override
	public void qnacreate(qnaDTO vo) throws Exception {
		qnaDao.qnacreate(vo);
	}

	// 리뷰 보기
	@Override
	public qnaDTO qnaread(int bno) throws Exception {
		return qnaDao.qnaread(bno);
	}

	// 리뷰 업데이트 보기
	@Override
	public qnaDTO qna_updatego(int bno) throws Exception {
		return qnaDao.qna_updatego(bno);
	}

	// 리뷰 업데이트
	@Override
	public void qnaupdate(qnaDTO vo) throws Exception {
		qnaDao.qnaupdate(vo);
	}

	// 리뷰 삭제
	@Override
	public void qnadelete(int bno) throws Exception {
		qnaDao.qnadelete(bno);
	}

	// 리뷰 보기
	@Override
	public List<qnaDTO> qna_product(int product_id) {
		return qnaDao.qna_product(product_id);
	}
}
