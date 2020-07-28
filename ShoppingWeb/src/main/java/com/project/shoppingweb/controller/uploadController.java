package com.project.shoppingweb.controller;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.shoppingweb.bean.boardDTO;
import com.project.shoppingweb.bean.shopDTO;
import com.project.shoppingweb.service.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class uploadController {
	@Inject
	shopService shopService;

	private static final Logger logger = LoggerFactory.getLogger(uploadController.class);

	@Resource(name = "uploadPath")
	String uploadPath;
}
