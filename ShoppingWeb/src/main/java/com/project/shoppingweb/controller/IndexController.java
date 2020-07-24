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
import org.springframework.beans.factory.annotation.Autowired;
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
	
	//È¨ÆäÀÌÁö
	@RequestMapping({ "/", "/home" })
	public String home() {
		return "home";
	}
	
	//¿Ê Ä«Å×°í¸®
	@RequestMapping("clothes")
	public String clothes() {
		return "clothes";
	}
	
	//¸®ºä°Ô½ÃÆÇ
	@RequestMapping("review")
	public String review() {
		return "review";
	}
	
	//°øÁö»çÇ×
	@RequestMapping("notice")
	public ModelAndView list() throws Exception{
        List<shopDTO> list = shopService.listAll();
        // ModelAndView - ëª¨ë¸ê³? ë·?
        ModelAndView mav = new ModelAndView();
        mav.setViewName("notice"); 
        mav.addObject("list", list); // ?°?´?„°ë¥? ???¥
        return mav; // list.jspë¡? Listê°? ? „?‹¬?œ?‹¤.
    }
	// 02_01. ê²Œì‹œê¸? ?‘?„±?™”ë©?
    // @RequestMapping("board/write.do")
    // value="", method="? „?†¡ë°©ì‹"
    @RequestMapping(value="write", method=RequestMethod.GET)
    public String write(){
        return "write"; // write.jspë¡? ?´?™
    }
    
    // 02_02. ê²Œì‹œê¸? ?‘?„±ì²˜ë¦¬
    @RequestMapping(value="insert", method=RequestMethod.POST)
    public String insert(@ModelAttribute shopDTO vo) throws Exception{
        shopService.create(vo);
        return "redirect:notice";
    }
    
    // 03. ê²Œì‹œê¸? ?ƒ?„¸?‚´?š© ì¡°íšŒ, ê²Œì‹œê¸? ì¡°íšŒ?ˆ˜ ì¦ê? ì²˜ë¦¬
    // @RequestParam : get/postë°©ì‹?œ¼ë¡? ? „?‹¬?œ ë³??ˆ˜ 1ê°?
    // HttpSession ?„¸?…˜ê°ì²´
    @RequestMapping(value="view", method=RequestMethod.GET)
    public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception{
        // ì¡°íšŒ?ˆ˜ ì¦ê? ì²˜ë¦¬
		/*
		 * shopService.increaseViewcnt(bno, session); // ëª¨ë¸(?°?´?„°)+ë·?(?™”ë©?)ë¥? ?•¨ê»? ? „?‹¬?•˜?Š” ê°ì²´
		 */       
    	ModelAndView mav = new ModelAndView();
        // ë·°ì˜ ?´ë¦?
        mav.setViewName("view");
        // ë·°ì— ? „?‹¬?•  ?°?´?„°
        mav.addObject("dto", shopService.read(bno));
        return mav;
    }
    
    // 04. ê²Œì‹œê¸? ?ˆ˜? •
    // ?¼?—?„œ ?…? ¥?•œ ?‚´?š©?“¤?? @ModelAttribute BoardVO voë¡? ? „?‹¬?¨
    @RequestMapping(value="update", method=RequestMethod.POST)
    public String update(@ModelAttribute shopDTO vo) throws Exception{
        shopService.update(vo);
        return "redirect:notice";
    }
    
    // 05. ê²Œì‹œê¸? ?‚­? œ
    @RequestMapping("delete")
    public String delete(@RequestParam int bno) throws Exception{
        shopService.delete(bno);
        return "redirect:notice";
    }
    
	
	
	//Àå¹Ù±¸´Ï È­¸é
	@RequestMapping("cart")
	public String cart() {
		return "cart";
	}
	
	//·Î±×ÀÎ È­¸é
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	//·Î±×ÀÎ Ã³¸®
	@RequestMapping(value = "/loginCheck")
	public ModelAndView loginCheck(@ModelAttribute shopDTO dto, HttpSession session) {
		boolean result = shopService.loginCheck(dto, session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		if(result) {
			mav.addObject("msg","¼º°ø");
		}else {
			mav.addObject("msg","½ÇÆĞ");
		}
		return mav;
	}
	//·Î±×¾Æ¿ô Ã³¸®
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
	
		shopService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("msg", "logout");
		return mav;
	}
	
	//È¸¿ø°¡ÀÔ È­¸é
	@RequestMapping("join")
	public String join(){
		return "join";
	}
	
	//È¸¿ø°¡ÀÔ ½ÇÇà
	@RequestMapping("goJoin")
	public String goJoin(shopDTO dto) {
		shopService.signUp(dto);
		return "login";
	}
	
	//produces´Â ajax »ç¿ë½Ã ±úÁü ¹æÁö
	@RequestMapping(value="idCheck", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		int result=shopService.idCheck(userId); 
		return Integer.toString(result);	
	}
		
	
	//ÀÇ·ù Ä«Å×°í¸® È­¸é
	@RequestMapping("outer")
	public String outer() {
		return "outer";
	}
	@RequestMapping("blouseshirts")
	public String blouseshirts() {
		return "blouseshirts";
	}
	@RequestMapping("top")
	public String top() {
		return "top";
	}
	@RequestMapping("bottom")
	public String bottom() {
		return "bottom";
	}
	@RequestMapping("dress")
	public String dress() {
		return "dress";
	}
	@RequestMapping("acc")
	public String acc() {
		return "acc";
	}
	
	
	 @RequestMapping("list")
	    public String listAll(Model model) {
	        List<shopDTO> list = shopService.listAll();
	       model.addAttribute("list",list);
	        return "member_list";
	    }
	
}
