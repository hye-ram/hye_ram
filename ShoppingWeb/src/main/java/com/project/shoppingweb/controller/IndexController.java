package com.project.shoppingweb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
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
	
	//����Խ���
	@RequestMapping("review")
	public String review() {
		return "review";
	}
	
	//��������
	@RequestMapping("notice")
	public ModelAndView list() throws Exception{
        List<shopDTO> list = shopService.listAll();
        // ModelAndView - 모델�? �?
        ModelAndView mav = new ModelAndView();
        mav.setViewName("notice"); 
        mav.addObject("list", list); // ?��?��?���? ???��
        return mav; // list.jsp�? List�? ?��?��?��?��.
    }
	// 02_01. 게시�? ?��?��?���?
    // @RequestMapping("board/write.do")
    // value="", method="?��?��방식"
    @RequestMapping(value="write", method=RequestMethod.GET)
    public String write(){
        return "write"; // write.jsp�? ?��?��
    }
    
    // 02_02. 게시�? ?��?��처리
    @RequestMapping(value="insert", method=RequestMethod.POST)
    public String insert(@ModelAttribute shopDTO vo) throws Exception{
        shopService.create(vo);
        return "redirect:notice";
    }
    
    // 03. 게시�? ?��?��?��?�� 조회, 게시�? 조회?�� 증�? 처리
    // @RequestParam : get/post방식?���? ?��?��?�� �??�� 1�?
    // HttpSession ?��?��객체
    @RequestMapping(value="view", method=RequestMethod.GET)
    public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception{
        // 조회?�� 증�? 처리
		/*
		 * shopService.increaseViewcnt(bno, session); // 모델(?��?��?��)+�?(?���?)�? ?���? ?��?��?��?�� 객체
		 */       
    	ModelAndView mav = new ModelAndView();
        // 뷰의 ?���?
        mav.setViewName("view");
        // 뷰에 ?��?��?�� ?��?��?��
        mav.addObject("dto", shopService.read(bno));
        return mav;
    }
    
    // 04. 게시�? ?��?��
    // ?��?��?�� ?��?��?�� ?��?��?��?? @ModelAttribute BoardVO vo�? ?��?��?��
    @RequestMapping(value="update", method=RequestMethod.POST)
    public String update(@ModelAttribute shopDTO vo) throws Exception{
        shopService.update(vo);
        return "redirect:notice";
    }
    
    // 05. 게시�? ?��?��
    @RequestMapping("delete")
    public String delete(@RequestParam int bno) throws Exception{
        shopService.delete(bno);
        return "redirect:notice";
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
		mav.setViewName("login");
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
		mav.setViewName("login");
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
	
	
	 @RequestMapping("list")
	    public String listAll(Model model) {
	        List<shopDTO> list = shopService.listAll();
	       model.addAttribute("list",list);
	        return "member_list";
	    }
	
}
