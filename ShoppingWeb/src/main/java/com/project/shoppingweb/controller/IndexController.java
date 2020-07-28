package com.project.shoppingweb.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 @Inject
	  shopService shopService;

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
	
	//Ȩ������
	@RequestMapping({ "/", "/home" })
	public String home() {
		return "home";
	}
	
	//�� ī�װ�
	@RequestMapping("clothes")
	public String clothes() {
		return "clothes";
	}
	
	
	//��ٱ��� ȭ��
	@RequestMapping("cart")
	public String cart() {
		return "cart";
	}
	
	//�α��� ȭ��
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	//�α��� ó��
	@RequestMapping(value = "/loginCheck")
	public ModelAndView loginCheck(@ModelAttribute shopDTO dto, HttpSession session) {
		boolean result = shopService.loginCheck(dto, session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		if(result) {
			mav.addObject("msg","성공");
		}else {
			mav.addObject("msg","실패");
		}
		return mav;
	}
	//�α׾ƿ� ó��
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		shopService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("msg", "logout");
		return mav;
	}
	
	//ȸ������ ȭ��
	@RequestMapping("join")
	public String join(){
		return "join";
	}
	
	//ȸ������ ����
	@RequestMapping("goJoin")
	public String goJoin(shopDTO dto) {
		shopService.signUp(dto);
		return "login";
	}
	
	//produces�� ajax ���� ���� ����
	@RequestMapping(value="idCheck", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		int result=shopService.idCheck(userId); 
		return Integer.toString(result);	
	}
		
	
	//�Ƿ� ī�װ� ȭ��
	@RequestMapping("mypage")
	public String outer() {
		return "mypage";
	}	
	
	@RequestMapping("memInfo")
	    public String listAll(Model model) throws Exception {
	        List<shopDTO> list = shopService.viewMember();
	       model.addAttribute("list",list);
	        return "member_list";
	}
	
	
}
