package com.project.shoppingweb.controller;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;

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

import com.project.shoppingweb.bean.CartDTO;
import com.project.shoppingweb.bean.boardDTO;
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

	// Ȩ������
	@RequestMapping({ "/", "/home" })
	public String home() {
		return "home";
	}

	// �� ī�װ�
	@RequestMapping("clothes")
	public String clothes() {
		return "clothes";
	}

	// ����Խ���
	@RequestMapping("review")
	public String review() {
		return "review";
	}

	// ��������
	@RequestMapping("notice")
	public ModelAndView list() throws Exception {
		List<boardDTO> list = shopService.listAll();
		// ModelAndView - 모델�? �?
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice");
		mav.addObject("list", list); // ?��?��?���? ???��
		return mav; // list.jsp�? List�? ?��?��?��?��.
	}

	// 02_01. 게시�? ?��?��?���?
	// @RequestMapping("board/write.do")
	// value="", method="?��?��방식"
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "write"; // write.jsp�? ?��?��
	}

	// 02_02. 게시�? ?��?��처리
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute boardDTO vo) throws Exception {
		shopService.create(vo);
		return "redirect:notice";
	}

	// 03. 게시�? ?��?��?��?�� 조회, 게시�? 조회?�� 증�? 처리
	// @RequestParam : get/post방식?���? ?��?��?�� �??�� 1�?
	// HttpSession ?��?��객체
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception {
		// 조회?�� 증�? 처리
		/*
		 * shopService.increaseViewcnt(bno, session); // 모델(?��?��?��)+�?(?���?)�? ?���?
		 * ?��?��?��?�� 객체
		 */
		ModelAndView mav = new ModelAndView();
		// 뷰의 ?���?
		mav.setViewName("view");
		// 뷰에 ?��?��?�� ?��?��?��
		mav.addObject("dto", shopService.read(bno));
		System.out.println(bno);
		System.out.println(mav);
		return mav;
	}

	// 04. 게시�? ?��?��
	// ?��?��?�� ?��?��?�� ?��?��?��?? @ModelAttribute BoardVO vo�? ?��?��?��
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute boardDTO vo) throws Exception {
		shopService.update(vo);
		return "redirect:notice";
	}

	// 05. 게시�? ?��?��
	@RequestMapping("delete")
	public String delete(@RequestParam int bno) throws Exception {
		shopService.delete(bno);
		return "redirect:notice";
	}


	// �α��� ȭ��
	@RequestMapping("login")
	public String login() {
		return "login";
	}

	// �α��� ó��
	@RequestMapping(value = "/loginCheck")
	public ModelAndView loginCheck(@ModelAttribute shopDTO dto, HttpSession session) {
		boolean result = shopService.loginCheck(dto, session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		if (result) {
			mav.addObject("msg", "성공");
		} else {
			mav.addObject("msg", "실패");
		}
		System.out.println(mav);
		return mav;
	}

	// �α׾ƿ� ó��
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		shopService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("msg", "logout");
		System.out.println(mav);
		return mav;
	}

	// ȸ������ ȭ��
	@RequestMapping("join")
	public String join() {
		return "join";
	}

	// ȸ������ ����
	@RequestMapping("goJoin")
	public String goJoin(shopDTO dto) {
		shopService.signUp(dto);
		return "login";
	}

	// produces�� ajax ���� ���� ����
	@RequestMapping(value = "idCheck", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		int result = shopService.idCheck(userId);
		return Integer.toString(result);
	}

	// 회원정보
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public  ModelAndView mypage(HttpSession session, ModelAndView mav) {
		String userId = (String) session.getAttribute("userId");
		if(userId!=null) { 
            //로그인한 상태이면 실행
			
			
			List<shopDTO> list = shopService.memInfo(userId);
			
            mav.setViewName("mypage"); //이동할 페이지의 이름
            mav.addObject("memInfo", list); //데이터 저장
            return mav; //화면 이동
        }else { //로그인하지 않은 상태
            return new ModelAndView("login", "", null);
            //로그인을 하지 않았으면 로그인 페이지로 이동시킨다.
        }
	}
	
	

	// 회원탈퇴 페이지
	@RequestMapping(value = "secession")
	public String secession() {
		return "secession";
	}

	// 회원탈퇴
	@RequestMapping(value = "secessionProc")
	public String secessionProc(shopDTO dto, HttpSession session) {
		shopService.secession(dto, session);
		return "login";
	}

	// 패스워드 체크
	@RequestMapping(value = "pwCheck", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String passCheck(shopDTO dto) {
		int result = shopService.passCheck(dto);
		return Integer.toString(result);
	}
}
