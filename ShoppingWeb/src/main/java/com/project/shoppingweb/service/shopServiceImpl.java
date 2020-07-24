package com.project.shoppingweb.service;

import java.util.List;

import javax.inject.*;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import com.project.shoppingweb.dao.*;
import com.project.shoppingweb.bean.*;

@Service 
public class shopServiceImpl implements shopService {
	
	@Inject
	shopDAO shopDao;

	@Override
	public boolean loginCheck(shopDTO dto, HttpSession session) {
		// TODO Auto-generated method stub
		
		boolean result = shopDao.loginCheck(dto);
		if (result == true) {	//true ÀÏ°æ¿ì ¼¼¼Ç µî·Ï
			//¼¼¼Ç º¯¼ö µî·Ï
			session.setAttribute("userId",dto.getUserId());
		}
		return result;
	}

	@Override
	public List<shopDTO> viewMember() throws Exception {
        return shopDao.listAll();
    }

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		shopDao.logout(session);
	}

	@Override
	public void create(shopDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}
    @Override
    public void create(shopDTO vo) throws Exception {
        String title = vo.getTitle();
        String content = vo.getContent();
        String writer = vo.getWriter();
        // *?ƒœê·¸ë¬¸? ì²˜ë¦¬ (< ==> &lt; > ==> &gt;)
        // replace(A, B) Aë¥? Bë¡? ë³?ê²?
        title = title.replace("<", "&lt;");
        title = title.replace("<", "&gt;");
        writer = writer.replace("<", "&lt;");
        writer = writer.replace("<", "&gt;");
        // *ê³µë°±ë¬¸ì ì²˜ë¦¬
        title = title.replace("  ",    "&nbsp;&nbsp;");
        writer = writer.replace("  ",    "&nbsp;&nbsp;");
        // *ì¤„ë°”ê¿? ë¬¸ìì²˜ë¦¬
        content = content.replace("\n", "<br>");
        vo.setTitle(title);
        vo.setContent(content);
        vo.setWriter(writer);
        shopDao.create(vo);
    }
    // 02. ê²Œì‹œê¸? ?ƒ?„¸ë³´ê¸°
    @Override
    public shopDTO read(int bno) throws Exception {
        return shopDao.read(bno);
    }
    // 03. ê²Œì‹œê¸? ?ˆ˜? •
    @Override
    public void update(shopDTO vo) throws Exception {
    	shopDao.update(vo);
    }
    // 04. ê²Œì‹œê¸? ?‚­? œ
    @Override
    public void delete(int bno) throws Exception {
    	shopDao.delete(bno);
    }
    // 05. ê²Œì‹œê¸? ? „ì²? ëª©ë¡
    @Override
    public List<shopDTO> listAll() throws Exception {
        return shopDao.listAll();
    }
    
	/*
	 * // 06. ê²Œì‹œê¸? ì¡°íšŒ?ˆ˜ ì¦ê?
	 * 
	 * @Override public void increaseViewcnt(int bno, HttpSession session) throws
	 * Exception { long update_time = 0; // ?„¸?…˜?— ???¥?œ ì¡°íšŒ?‹œê°? ê²??ƒ‰ // ìµœì´ˆë¡? ì¡°íšŒ?•  ê²½ìš° ?„¸?…˜?— ???¥?œ ê°’ì´
	 * ?—†ê¸? ?•Œë¬¸ì— ifë¬¸ì? ?‹¤?–‰X if(session.getAttribute("update_time_"+bno) != null){ // ?„¸?…˜?—?„œ
	 * ?½?–´?˜¤ê¸? update_time = (long)session.getAttribute("update_time_"+bno); } // ?‹œ?Š¤?…œ?˜
	 * ?˜„?¬?‹œê°„ì„ current_time?— ???¥ long current_time = System.currentTimeMillis(); //
	 * ?¼? •?‹œê°„ì´ ê²½ê³¼ ?›„ ì¡°íšŒ?ˆ˜ ì¦ê? ì²˜ë¦¬ 24*60*60*1000(24?‹œê°?) // ?‹œ?Š¤?…œ?˜„?¬?‹œê°? - ?—´?Œ?‹œê°? > ?¼? •?‹œê°?(ì¡°íšŒ?ˆ˜ ì¦ê?ê°?
	 * ê°??Š¥?•˜?„ë¡? ì§?? •?•œ ?‹œê°?) if(current_time - update_time > 5*1000){
	 * shopDao.increaseViewcnt(bno); // ?„¸?…˜?— ?‹œê°„ì„ ???¥ : "update_time_"+bno?Š” ?‹¤ë¥¸ë??ˆ˜?? ì¤‘ë³µ?˜ì§?
	 * ?•Šê²? ëª…ëª…?•œ ê²? session.setAttribute("update_time_"+bno, current_time);
	 * 
	 * } }
	 */

	@Override
	public shopDTO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(shopDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<shopDTO> listAll() {
		// TODO Auto-generated method stub
		return shopDao.listAll();
	}

	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	// 01. °¡ÀÔ ¾ÆÀÌµğ Áßº¹ Ã¼Å©
	@Override
	public int idCheck(String userId) {
		int result = shopDao.idCheck(userId);
		return result;
	}
	// 02. °¡ÀÔ 
	@Override
	public void signUp(shopDTO dto) {
		shopDao.signUp(dto);
	}

}
