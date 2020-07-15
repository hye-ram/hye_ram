package com.project.shoppingweb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
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

	@RequestMapping("join")
	public String join() {
		return "join";
	}
	

}
