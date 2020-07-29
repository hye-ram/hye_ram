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
	        return mav; // list.jsp�? List�? ?��?��?��?��.
	    }
		
		//리뷰게시판 글쓰기 페이지로 이동
	    @RequestMapping(value="re_write", method=RequestMethod.GET)
	    public String re_write(){
	        return "re_write"; // write.jsp�? ?��?��
	    }
		
	    //리뷰게시판 글쓰기
	    @RequestMapping(value="reinsert", method=RequestMethod.POST)
	    public String insert(@ModelAttribute reviewDTO vo) throws Exception{

	    	System.out.println("컨트롤러"+vo);
	    	reviewService.reviewcreate(vo);
	        return "redirect:review";
	    }
	    
	    //리뷰 보기
	    @RequestMapping(value="re_view", method=RequestMethod.GET)
	    public ModelAndView re_view(@RequestParam int bno, HttpSession session) throws Exception{   
	    	ModelAndView mav = new ModelAndView();
	        mav.setViewName("re_view");
	        mav.addObject("rdto", reviewService.reviewread(bno));
	        return mav;
	    }
	      
	    //리뷰 업뎃
	    @RequestMapping(value="re_update", method=RequestMethod.POST)
	    public String re_update(@ModelAttribute reviewDTO vo) throws Exception{
	    	reviewService.reviewupdate(vo);
	        return "redirect:review";
	    }
	    
	    // 리뷰 삭제
	    @RequestMapping("re_delete")
	    public String re_delete(@RequestParam int bno) throws Exception{
	    	reviewService.reviewdelete(bno);
	        return "redirect:review";
	    }
	    
	   
	  
}
