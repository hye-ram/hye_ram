package com.project.shoppingweb.controller;

import java.util.List;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.servlet.ModelAndView;

import com.project.shoppingweb.bean.boardDTO;
import com.project.shoppingweb.bean.reviewDTO;
import com.project.shoppingweb.service.reviewService;

@Controller
@SessionAttributes("login")
public class ReviewController {
	 @Inject
	  reviewService reviewService;
	 
	 private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	 
	//리뷰게시판
		@RequestMapping("review")
		public ModelAndView reviewlist() throws Exception{
	        List<reviewDTO> list = reviewService.reviewlistAll();
	        // ModelAndView - 모델�? �?
	        ModelAndView mav = new ModelAndView();
	        mav.setViewName("review"); 
	        mav.addObject("list", list); // ?��?��?���? ???��
	        return mav; 
	    }
		
		//리뷰게시판 글쓰기 페이지로 이동
	    @RequestMapping(value="review_write", method=RequestMethod.GET)
	    public String re_write(){
	        return "review_write"; 
	    }
		
	    //리뷰게시판 글쓰기
	    @RequestMapping(value="review_insert", method=RequestMethod.POST)
	    public String insert(HttpServletRequest request, reviewDTO dto) throws Exception{
	    	System.out.println(request.getParameter("ir1"));
	    	dto.setTitle(request.getParameter("title"));
	    	dto.setEditor(request.getParameter("ir1"));
	    	dto.setWriter(request.getParameter("writer"));
	    	
	    	reviewService.reviewcreate(dto);
	        return "redirect:review";
	    }
	    
	    //리뷰 보기
	    @RequestMapping(value="review_view", method=RequestMethod.GET)
	    public ModelAndView re_view(@RequestParam int bno, HttpSession session) throws Exception{   
	    	ModelAndView mav = new ModelAndView();
	        mav.setViewName("re_view");
	        mav.addObject("rdto", reviewService.reviewread(bno));
	        return mav;
	    }
	      
	    //리뷰 업뎃
	    @RequestMapping(value="review_update", method=RequestMethod.POST)
	    public String re_update(HttpServletRequest request, reviewDTO dto) throws Exception{
	    	System.out.println(request.getParameter("ir1"));
	    	dto.setTitle(request.getParameter("title"));
	    	dto.setEditor(request.getParameter("ir1"));
	    	dto.setWriter(request.getParameter("writer"));
	    	
	    	reviewService.reviewupdate(dto);
	        return "redirect:review";
	    }
	    
	    // 리뷰 삭제
	    @RequestMapping("review_delete")
	    public String re_delete(@RequestParam int bno) throws Exception{
	    	reviewService.reviewdelete(bno);
	        return "redirect:review";
	    }
	    
	   
	  
}
