package com.project.shoppingweb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.shoppingweb.bean.shopDTO;
import com.project.shoppingweb.service.*;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("login")
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 *//*
		 * @RequestMapping("/") public String home(Locale locale, Model model) {
		 * logger.info("Welcome home! The client locale is {}.", locale);
		 * 
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 * 
		 * model.addAttribute("serverTime", formattedDate );
		 * 
		 * return "home"; }
		 */
	
	@Autowired
	private shopService shopService;
	
	//홈페이지
	@RequestMapping({ "/", "/home" })
	public String home() {
		return "home";
	}
	
	//옷 카테고리
	@RequestMapping("clothes")
	public String clothes() {
		return "clothes";
	}
	
	//리뷰게시판
	@RequestMapping("review")
	public String review() {
		return "review";
	}
	
	//공지사항
	@RequestMapping("notice")
	public String notice() {
		return "notice";
	}
	
	//장바구니 화면
	@RequestMapping("cart")
	public String cart() {
		return "cart";
	}
	
	//로그인 화면
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	//로그인 처리
	@RequestMapping(value = "/loginCheck")
	public ModelAndView loginCheck(@ModelAttribute shopDTO dto, HttpSession session) {
		boolean result = shopService.loginCheck(dto, session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		if(result) {
			mav.addObject("msg","성공");
		}else {
			mav.addObject("msg","실패");
		}
		return mav;
	}
	//로그아웃 처리
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
	
		shopService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("msg", "logout");
		return mav;
	}
	
	//회원가입 화면
	@RequestMapping("join")
	public String join(){
		return "join";
	}
	
	//회원가입 실행
	@RequestMapping("goJoin")
	public String goJoin(shopDTO dto) {
		shopService.signUp(dto);
		return "login";
	}
	
	//produces는 ajax 사용시 깨짐 방지
	@RequestMapping(value="idCheck", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		int result=shopService.idCheck(userId); 
		return Integer.toString(result);	
	}
		
	
	//의류 카테고리 화면
	@RequestMapping("outer")
	public String outer() {
		return "outer";
	}
	@RequestMapping("blouseshirts")
	public String blouseshirts() {
		return "blouseshirts";
	}
	@RequestMapping("top")
	public String top() {
		return "top";
	}
	@RequestMapping("bottom")
	public String bottom() {
		return "bottom";
	}
	@RequestMapping("dress")
	public String dress() {
		return "dress";
	}
	@RequestMapping("acc")
	public String acc() {
		return "acc";
	}
	
	
	 @RequestMapping("list")
	    public String listAll(Model model) {
	        List<shopDTO> list = shopService.listAll();
	       model.addAttribute("list",list);
	        return "member_list";
	    }
	
}
