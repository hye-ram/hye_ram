package com.project.shoppingweb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.shoppingweb.bean.shopDTO;

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
	@RequestMapping({ "/", "/home" })
	public String home() {
		return "home";
	}
	@RequestMapping("clothes")
	public String clothes() {
		return "clothes";
	}
	@RequestMapping("review")
	public String review() {
		return "review";
	}
	@RequestMapping("notice")
	public String notice() {
		return "notice";
	}
	@RequestMapping("cart")
	public String cart() {
		return "cart";
	}

	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	/*
	 * @Autowired private MemberService memberService;
	 * 
	 * //로그인 처리
	 * 
	 * @RequestMapping(value="/loginCheck.do") public ModelAndView
	 * loginCheck(@ModelAttribute shopDTO dto, HttpSession session) {
	 * 
	 * boolean result = memberService.loginCheck(dto, session); ModelAndView mav =
	 * new ModelAndView();
	 * 
	 * mav.setViewName("login");
	 * 
	 * if(result) { mav.addObject("msg","성공"); }else { mav.addObject("msg","실패"); }
	 * 
	 * return mav; }
	 * 
	 * //로그아웃 처리
	 * 
	 * @RequestMapping("logout.do") public ModelAndView logout(HttpSession session)
	 * {
	 * 
	 * memberService.logout(session); ModelAndView mav = new ModelAndView();
	 * mav.setViewName("login"); mav.addObject("msg", "logout");
	 * 
	 * return mav; }
	 * 
	 * @RequestMapping("join") public String join() { return "join"; }
	 */
	

}
