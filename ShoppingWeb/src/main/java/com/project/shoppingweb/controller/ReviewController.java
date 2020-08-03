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
		mav.addObject("list", list); // ?��?��?���? ???��
		return mav;
	}

	// 리뷰게시판 글쓰기 페이지로 이동
	@RequestMapping(value = "review_write", method = RequestMethod.GET)
	public String re_write() {
		return "review_write";
	}

	// 리뷰게시판 글쓰기
	@RequestMapping(value = "review_insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, reviewDTO dto) throws Exception {
		System.out.println(request.getParameter("ir1"));
		dto.setTitle(request.getParameter("title"));
		dto.setEditor(request.getParameter("ir1"));
		dto.setWriter(request.getParameter("writer"));

		reviewService.reviewcreate(dto);
		return "redirect:review";
	}

	// 리뷰 보기
	@RequestMapping(value = "review_view", method = RequestMethod.GET)
	public ModelAndView re_view(@RequestParam int bno, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("re_view");
		mav.addObject("rdto", reviewService.reviewread(bno));
		return mav;
	}

	// 리뷰 업뎃
	@RequestMapping(value = "review_update", method = RequestMethod.POST)
	public String re_update(HttpServletRequest request, reviewDTO dto) throws Exception {
		System.out.println(request.getParameter("ir1"));
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

	// 파일 업로드-스마트에디터(싱글)

/*	@RequestMapping(value="/file_uploader")
	public String simpleImageUploader(
		HttpServletRequest req, reviewDTO dto) 
        	throws UnsupportedEncodingException{
	String callback = smarteditorVO.getCallback();
	String callback_func = smarteditorVO.getCallback_func();
	String file_result = "";
	String result = "";
	MultipartFile multiFile = smarteditorVO.getFiledata();
	try{
		if(multiFile != null && multiFile.getSize() > 0 && 
        		StringUtils.isNotBlank(multiFile.getName())){
			if(multiFile.getContentType().toLowerCase().startsWith("image/")){
            	String oriName = multiFile.getName();
                String uploadPath = req.getServletContext().getRealPath("/img");
                String path = uploadPath + "/smarteditor/";
                File file = new File(path);
                if(!file.exists()){
                file.mkdirs();
                }
                String fileName = UUID.randomUUID().toString();
                smarteditorVO.getFiledata().transferTo(new File(path + fileName));
                file_result += "&bNewLine=true&sFileName=" + oriName + 
                			   "&sFileURL=/img/smarteditor/" + fileName;
			}else{
				file_result += "&errstr=error";
			}
		}else{
			file_result += "&errstr=error";
		}
	} catch (Exception e){
		e.printStackTrace();
	}
	result = "redirect:" + callback + 
			 "?callback_func=" + URLEncoder.encode(callback_func,"UTF-8") + file_result;
	return result;
}*/
	// 파일 업로더 멀티

	@RequestMapping(value = "/file_uploader_html5", method = { RequestMethod.POST, RequestMethod.GET })
	public String file_uploader(HttpServletRequest request, HttpServletResponse response, reviewDTO dto) {
		String return1 = request.getParameter("callback");
		String return2 = "?callback_func=" + request.getParameter("callback_func");
		String return3 = "";
		String name = "";
		try {
			if (dto.getFiledata() != null && dto.getFiledata().getOriginalFilename() != null
					&& !dto.getFiledata().getOriginalFilename().equals("")) {
				// 기존 상단 코드를 막고 하단코드를 이용
				name = dto.getFiledata().getOriginalFilename()
						.substring(dto.getFiledata().getOriginalFilename().lastIndexOf(File.separator) + 1);
				String filename_ext = name.substring(name.lastIndexOf(".") + 1);
				filename_ext = filename_ext.toLowerCase();
				String[] allow_file = { "jpg", "png", "bmp", "gif" };
				int cnt = 0;
				for (int i = 0; i < allow_file.length; i++) {
					if (filename_ext.equals(allow_file[i])) {
						cnt++;
					}
				}
				if (cnt == 0) {
					return3 = "&errstr=" + name;
				} else {
					// 파일 기본경로
					String dftFilePath = request.getSession().getServletContext().getRealPath("/");
					// 파일 기본경로 _ 상세경로
					String filePath = dftFilePath + "smarteditor2" + File.separator + "upload" + File.separator;
					File file = new File(filePath);
					if (!file.exists()) {
						file.mkdirs();
						System.out.println(file + "멀티성공");
					} else {
						System.out.println("멀티실패");
					}
					String realFileNm = "";
					SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
					String today = formatter.format(new java.util.Date());
					realFileNm = today + UUID.randomUUID().toString() + name.substring(name.lastIndexOf("."));
					String rlFileNm = filePath + realFileNm;
					///////////////// 서버에 파일쓰기 /////////////////
					dto.getFiledata().transferTo(new File(rlFileNm));
					///////////////// 서버에 파일쓰기 /////////////////
					return3 += "&bNewLine=true";
					return3 += "&sFileName=" + name;
					return3 += "&sFileURL=/smarteditor2/upload/" + realFileNm;
				}
			} else {
				return3 += "&errstr=error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + return1 + return2 + return3;
	}

}
