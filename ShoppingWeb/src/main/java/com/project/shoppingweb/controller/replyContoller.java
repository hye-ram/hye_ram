package com.project.shoppingweb.controller;



import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.shoppingweb.bean.*;
import com.project.shoppingweb.service.*;

@Controller
@SessionAttributes("login")
public class replyContoller {
	@Inject
	replyService replyService;
	

	// 댓글 입력
	@RequestMapping(value="reply_insert", method=RequestMethod.POST)
	@ResponseBody
	public void insert(@ModelAttribute replyDTO vo, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		vo.setReplyer(userId);
		replyService.create(vo);
		
	}

	// 댓글 목록(@Controller방식 : veiw(화면)를 리턴)
	@RequestMapping(value="reply_list", method=RequestMethod.GET)
	public ModelAndView list(@RequestParam int bno, ModelAndView mav) {
		List<replyDTO> list = replyService.list(bno);
		mav.setViewName("replyList");
		mav.addObject("list", list);
		return mav;
	}

}
