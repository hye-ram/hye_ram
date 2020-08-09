package com.project.shoppingweb.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.shoppingweb.bean.boardDTO;
import com.project.shoppingweb.service.boardService;

@Controller
@SessionAttributes("login")

public class BoardController {
	@Inject
	boardService boardService;

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	// 게시판 리스트
	@RequestMapping("notice")
	public ModelAndView notice_list() throws Exception {
		List<boardDTO> list = boardService.listAll();
		// ModelAndView - 모델�? �?
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice");
		mav.addObject("list", list); // ?��?��?���? ???��
		return mav; // list.jsp�? List�? ?��?��?��?��.
	}

	// 게시판 글쓰기 페이지로 이동
	@RequestMapping(value = "notice_write", method = RequestMethod.GET)
	public String notice_write() {
		return "notice_write"; // write.jsp�? ?��?��
	}

	// 게시판 글 쓰기
	@RequestMapping(value = "notice_insert")
	public String notice_insert(boardDTO vo) throws Exception {
		// 파일 업로드 처리
		String fname = null;
		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName); // 확장자 구하기
			UUID uuid = UUID.randomUUID(); // UUID 구하기
			fname = uuid + "." + ext;
			uploadFile.transferTo(new File("D:\\upload\\" + fname));
		}
		vo.setFname(fname);
		boardService.create(vo);
		return "redirect:notice";
	}

	// 게시판 글 보기
	@RequestMapping(value = "notice_view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice_view");
		mav.addObject("dto", boardService.read(bno));
		return mav;
	}
	// 게시판 업데이트 페이지 보기
		@RequestMapping(value = "notice_updatego", method = {RequestMethod.GET, RequestMethod.POST})
		public ModelAndView reviewUp(@RequestParam int bno, HttpSession session) throws Exception {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("notice_update");
			mav.addObject("dto", boardService.notice_updatego(bno));
			return mav;
		}
		

	// 게시판 업데이트
	@RequestMapping(value = "notice_update", method = RequestMethod.POST)
	public String update(@ModelAttribute boardDTO vo) throws Exception {
		boardService.update(vo);
		return "redirect:notice";
	}

	// 게시판 삭제
	@RequestMapping("notice_delete")
	public String delete(@RequestParam int bno) throws Exception {
		boardService.delete(bno);
		return "redirect:notice";
	}

}
