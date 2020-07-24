package com.project.shoppingweb.controller;

import java.util.List;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.shoppingweb.bean.shopDTO;
import com.project.shoppingweb.service.shopService;

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
	public ModelAndView list() throws Exception{
        List<shopDTO> list = shopService.listAll();
        // ModelAndView - 모델과 뷰
        ModelAndView mav = new ModelAndView();
        mav.setViewName("notice"); 
        mav.addObject("list", list); // 데이터를 저장
        return mav; // list.jsp로 List가 전달된다.
    }
	// 02_01. 게시글 작성화면
    // @RequestMapping("board/write.do")
    // value="", method="전송방식"
    @RequestMapping(value="write", method=RequestMethod.GET)
    public String write(){
        return "write"; // write.jsp로 이동
    }
    
    // 02_02. 게시글 작성처리
    @RequestMapping(value="insert", method=RequestMethod.POST)
    public String insert(@ModelAttribute shopDTO vo) throws Exception{
        shopService.create(vo);
        return "redirect:notice";
    }
    
    // 03. 게시글 상세내용 조회, 게시글 조회수 증가 처리
    // @RequestParam : get/post방식으로 전달된 변수 1개
    // HttpSession 세션객체
    @RequestMapping(value="view", method=RequestMethod.GET)
    public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception{
        // 조회수 증가 처리
		/*
		 * shopService.increaseViewcnt(bno, session); // 모델(데이터)+뷰(화면)를 함께 전달하는 객체
		 */       
    	ModelAndView mav = new ModelAndView();
        // 뷰의 이름
        mav.setViewName("view");
        // 뷰에 전달할 데이터
        mav.addObject("dto", shopService.read(bno));
        return mav;
    }
    
    // 04. 게시글 수정
    // 폼에서 입력한 내용들은 @ModelAttribute BoardVO vo로 전달됨
    @RequestMapping(value="update", method=RequestMethod.POST)
    public String update(@ModelAttribute shopDTO vo) throws Exception{
        shopService.update(vo);
        return "redirect:notice";
    }
    
    // 05. 게시글 삭제
    @RequestMapping("delete")
    public String delete(@RequestParam int bno) throws Exception{
        shopService.delete(bno);
        return "redirect:notice";
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
	 * //�α��� ó��
	 * 
	 * @RequestMapping(value="/loginCheck.do") public ModelAndView
	 * loginCheck(@ModelAttribute shopDTO dto, HttpSession session) {
	 * 
	 * boolean result = memberService.loginCheck(dto, session); ModelAndView mav =
	 * new ModelAndView();
	 * 
	 * mav.setViewName("login");
	 * 
	 * if(result) { mav.addObject("msg","����"); }else { mav.addObject("msg","����"); }
	 * 
	 * return mav; }
	 * 
	 * //�α׾ƿ� ó��
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
