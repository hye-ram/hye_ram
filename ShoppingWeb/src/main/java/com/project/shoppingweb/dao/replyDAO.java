package com.project.shoppingweb.dao;

import java.util.List;
import com.project.shoppingweb.bean.replyDTO;


public interface replyDAO {
	 // 댓글 목록
    public List<replyDTO> list(Integer bno);
    // 댓글 입력
    public void create(replyDTO vo);
    // 댓글 수정
    public void update(replyDTO vo);
    // 댓글 삭제
    public void delete(Integer rno);
	}
