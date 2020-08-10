package com.project.shoppingweb.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.shoppingweb.bean.qnaDTO;
import com.project.shoppingweb.service.QnaService;

@Controller
@SessionAttributes("login")
public class QnaController {
	
	@Inject
	QnaService qnaService;

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	// 리뷰게시판
	@RequestMapping("qna")
	public ModelAndView qnalist() throws Exception {
		List<qnaDTO> list = qnaService.qnalistAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna");
		mav.addObject("list", list);
		return mav;
	}

	// 리뷰게시판 글쓰기 페이지로 이동
	@RequestMapping(value = "qna_write", method = RequestMethod.GET)
	public String qna_write(HttpServletRequest request) {
		String id = request.getParameter("product_id");
		return "qna_write";
	}

	// 리뷰게시판 글쓰기
	@RequestMapping(value = "qna_insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, qnaDTO dto, HttpSession session) throws Exception {
		String writer = (String) session.getAttribute("userId");
		String product_id = request.getParameter("product_id");
		dto.setTitle(request.getParameter("title"));
		dto.setEditor(request.getParameter("ir1"));
		dto.setWriter(writer);
		qnaService.qnacreate(dto);
		return "redirect:qna";
	}

	// 리뷰 보기
	@RequestMapping(value = "qna_view", method = RequestMethod.GET)
	public ModelAndView qna_view(@RequestParam int bno, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna_view");
		mav.addObject("qdto", qnaService.qnaread(bno));
		return mav;
	}

	// 리뷰 업데이트 보기
	@RequestMapping(value = "qna_updatego", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView qnaUp(@RequestParam int bno, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna_update");
		mav.addObject("qdto", qnaService.qna_updatego(bno));
		return mav;
	}

	// 리뷰 업뎃
	@RequestMapping(value = "qna_update", method = RequestMethod.POST)
	public String qna_update(HttpServletRequest request, qnaDTO dto) throws Exception {
		dto.setTitle(request.getParameter("title"));
		dto.setEditor(request.getParameter("ir1"));
		dto.setWriter(request.getParameter("writer"));

		qnaService.qnaupdate(dto);
		return "redirect:qna_view?bno=" + dto.getBno();
	}

	// 리뷰 삭제
	@RequestMapping("qna_delete")
	public String qna_delete(@RequestParam int bno) throws Exception {
		qnaService.qnadelete(bno);
		return "redirect:qna";
	}
}
