package com.project.shoppingweb.service;

import java.util.List;
import javax.servlet.http.HttpSession;
import com.project.shoppingweb.dao.*;
import com.project.shoppingweb.bean.*;

public interface shopService {
<<<<<<< HEAD
	// 01. °Ô½Ã±Û ÀÛ¼º
	public void create(shopDTO dto) throws Exception;
	// 02. °Ô½Ã±Û »ó¼¼º¸±â
	public shopDTO read(int bno) throws Exception;
	// 03. °Ô½Ã±Û ¼öÁ¤
	public void update(shopDTO dto) throws Exception;
	// 04. °Ô½Ã±Û »èÁ¦
	public void delete(int bno) throws Exception;
	// 05. °Ô½Ã±Û ÀüÃ¼ ¸ñ·Ï
	public List<shopDTO> listAll();
	// 06. °Ô½Ã±Û Á¶È¸
	public void increaseViewcnt(int bno, HttpSession session) throws Exception;
	
	// 01. È¸¿ø ·Î±×ÀÎ Ã¼Å©
=======
	 // 01. ê²Œì‹œê¸€ ì‘ì„±
    public void create(shopDTO vo) throws Exception;
    // 02. ê²Œì‹œê¸€ ìƒì„¸ë³´ê¸°
    public shopDTO read(int bno) throws Exception;
    // 03. ê²Œì‹œê¸€ ìˆ˜ì •
    public void update(shopDTO vo) throws Exception;
    // 04. ê²Œì‹œê¸€ ì‚­ì œ
    public void delete(int bno) throws Exception;
    // 05. ê²Œì‹œê¸€ ì „ì²´ ëª©ë¡
    public List<shopDTO> listAll() throws Exception;

	/*
	 * // 06. ê²Œì‹œê¸€ ì¡°íšŒ public void increaseViewcnt(int bno, HttpSession session)
	 * throws Exception;
	 */
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	public boolean loginCheck(shopDTO dto, HttpSession session);
<<<<<<< HEAD
	// 02. È¸¿ø ·Î±×ÀÎ Á¤º¸
	public List<shopDTO> viewMember() throws Exception;
	// 03. È¸¿ø ·Î±×¾Æ¿ô
=======
	// 02. È¸ï¿½ï¿½ ï¿½Î±ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	public shopDTO viewMember(shopDTO dto);
	// 03. È¸ï¿½ï¿½ ï¿½Î±×¾Æ¿ï¿½
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	public void logout(HttpSession session);
	
	// 01. °¡ÀÔ ¾ÆÀÌµğ Áßº¹ Ã¼Å©
	public int idCheck(String userId);
	// 02. °¡ÀÔ 
	public void signUp(shopDTO dto);
}
