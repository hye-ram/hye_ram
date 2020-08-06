package com.project.shoppingweb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.project.shoppingweb.bean.boardDTO;
import com.project.shoppingweb.bean.reviewDTO;
import com.project.shoppingweb.service.reviewService;

@Controller
@SessionAttributes("login")
public class ReviewController {
	@Inject
	reviewService reviewService;

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	// 리뷰게시판
	@RequestMapping("review")
	public ModelAndView reviewlist() throws Exception {
		List<reviewDTO> list = reviewService.reviewlistAll();
		// ModelAndView - 모델�? �?
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review");
		mav.addObject("list", list);
		return mav;
	}

	// 리뷰게시판 글쓰기 페이지로 이동
	@RequestMapping(value = "review_write", method = RequestMethod.GET)
	public String re_write() {
		return "review_write";
	}

	// 리뷰게시판 글쓰기
	@RequestMapping(value = "review_insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, reviewDTO dto,HttpSession session) throws Exception {
		String writer = (String) session.getAttribute("userId");
		dto.setTitle(request.getParameter("title"));
		dto.setEditor(request.getParameter("ir1"));
		dto.setWriter(writer);
		reviewService.reviewcreate(dto);
		return "redirect:review";
	}
	// 리뷰  보기
	@RequestMapping(value = "review_view", method = RequestMethod.GET)
	public ModelAndView re_view(@RequestParam int bno, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review_view");
		mav.addObject("rdto", reviewService.reviewread(bno));
		return mav;
	}
	
	// 리뷰 업데이트 보기
	@RequestMapping(value = "review_updatego", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView reviewUp(@RequestParam int bno, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review_update");
		mav.addObject("rdto", reviewService.review_updatego(bno));
		return mav;
	}
	

	// 리뷰 업뎃
	@RequestMapping(value = "review_update", method = RequestMethod.POST)
	public String re_update(HttpServletRequest request, reviewDTO dto) throws Exception {
		dto.setTitle(request.getParameter("title"));
		dto.setEditor(request.getParameter("ir1"));
		dto.setWriter(request.getParameter("writer"));

		reviewService.reviewupdate(dto);
		return "redirect:review";
	}
	

	// 리뷰 삭제
	@RequestMapping("review_delete")
	public String re_delete(@RequestParam int bno) throws Exception {
		reviewService.reviewdelete(bno);
		return "redirect:review";
	}

	
	//단일파일업로드
	@RequestMapping("/photoUpload")
	public String photoUpload(HttpServletRequest request, reviewDTO vo){
	    String callback = vo.getCallback();
	    String callback_func = vo.getCallback_func();
	    String file_result = "";
	    try {
	        if(vo.getFiledata() != null && vo.getFiledata().getOriginalFilename() != null && !vo.getFiledata().getOriginalFilename().equals("")){
	            //파일이 존재하면
	            String original_name = vo.getFiledata().getOriginalFilename();
	            String ext = original_name.substring(original_name.lastIndexOf(".")+1);
	            //파일 기본경로
	            String defaultPath = request.getSession().getServletContext().getRealPath("/");
	            System.out.println(defaultPath);
	            //파일 기본경로 _ 상세경로
	            String path = defaultPath + "smarteditor2/photo_upload" + File.separator;             
	            File file = new File(path);
	            System.out.println("path:"+path);
	            //디렉토리 존재하지 않을경우 디렉토리 생성
	            if(!file.exists()) {
	                file.mkdirs();
	            }
	            //서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는것이 좋음)
	            String realname = UUID.randomUUID().toString() + "." + ext;
	        ///////////////// 서버에 파일쓰기 /////////////////
	            vo.getFiledata().transferTo(new File(path+realname));
	            file_result += "&bNewLine=true&sFileName="+original_name+"&sFileURL=/resource/photo_upload/"+realname;
	        } else {
	            file_result += "&errstr=error";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "redirect:" + callback + "?callback_func="+callback_func+file_result;
	}



	//다중파일업로드
	@RequestMapping(value = "/multiplePhotoUpload" ,  method = {RequestMethod.GET, RequestMethod.POST})
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response){
	    try {
	         //파일정보
	         String sFileInfo = "";
	         //파일명을 받는다 - 일반 원본파일명
	         String filename = request.getHeader("file-name");
	         //파일 확장자
	         String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
	         //확장자를소문자로 변경
	         filename_ext = filename_ext.toLowerCase();
	         //파일 기본경로
	         String dftFilePath = request.getSession().getServletContext().getRealPath("/");
	         System.out.println(dftFilePath);
	         //파일 기본경로 _ 상세경로
	         String filePath = dftFilePath + "smarteditor2/photo_upload" + File.separator;
	         File file = new File(filePath);
	         if(!file.exists()) {
	            file.mkdirs();
	         }
	         String realFileNm = "";
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	         String today= formatter.format(new java.util.Date());
	         realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
	         String rlFileNm = filePath + realFileNm;
	         ///////////////// 서버에 파일쓰기 /////////////////
	         InputStream is = request.getInputStream();
	         OutputStream os=new FileOutputStream(rlFileNm);
	         int numRead;
	         byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
	         while((numRead = is.read(b,0,b.length)) != -1){
	            os.write(b,0,numRead);
	         }
	         if(is != null) {
	            is.close();
	         }
	         os.flush();
	         os.close();
	         ///////////////// 서버에 파일쓰기 /////////////////
	         // 정보 출력
	         sFileInfo += "&bNewLine=true";
	         // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
	         sFileInfo += "&sFileName="+ filename;;
	         sFileInfo += "&sFileURL="+"/smarteditor2/photo_upload/"+realFileNm;
	         PrintWriter print = response.getWriter();
	         print.print(sFileInfo);
	         print.flush();
	         print.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}

}
