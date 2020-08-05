package com.project.shoppingweb.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.project.shoppingweb.bean.replyDTO;
import com.project.shoppingweb.dao.replyDAO;


@Service
public class replyServiceImpl implements replyService {

	@Inject
	replyDAO replyDao;

	// 댓글 목록
    @Override
    public List<replyDTO> list(Integer bno) {
        return replyDao.list(bno);
    }
    // 댓글 작성
    @Override
    public void create(replyDTO vo) {
        replyDao.create(vo);
    }
    // 댓글 수정
    @Override
    public void update(replyDTO vo) {
        // TODO Auto-generated method stub
 
    }
    // 댓글 삭제
    @Override
    public void delete(Integer rno) {
        // TODO Auto-generated method stub
 
    }

}