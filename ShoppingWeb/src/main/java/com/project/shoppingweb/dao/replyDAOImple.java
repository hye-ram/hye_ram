package com.project.shoppingweb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.shoppingweb.bean.replyDTO;

@Repository
public class replyDAOImple implements replyDAO {
	

	    @Inject
	    SqlSession sqlSession;
	    
	 // 댓글 목록
	    @Override
	    public List<replyDTO> list(Integer bno) {
	        return sqlSession.selectList("reply.listReply", bno);
	    }
	    // 댓글 작성
	    @Override
	    public void create(replyDTO vo) {
	        sqlSession.insert("reply.insertReply", vo);
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
	 
