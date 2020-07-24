package com.project.shoppingweb.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.shoppingweb.bean.*;



@Repository
public interface shopDAO {
<<<<<<< HEAD
=======
	
	
	// 01. È¸ï¿½ï¿½ ï¿½Î±ï¿½ï¿½ï¿½ Ã¼Å©
	
	 public boolean loginCheck(shopDTO dto);
	 
	 // 02. È¸ï¿½ï¿½ ï¿½Î±ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ 
	 public shopDTO viewMember(shopDTO dto); 
	 // 03. È¸ï¿½ï¿½ ï¿½Î±×¾Æ¿ï¿½
	 public void logout(HttpSession session);
	 
	// 01. ê²Œì‹œê¸€ ìž‘ì„±
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
		 * // 06. ê²Œì‹œê¸€ ì¡°íšŒ ì¦ê°€ public void increaseViewcnt(int bno) throws Exception;
		 */
	
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git

	// 01. È¸¿ø ·Î±×ÀÎ Ã¼Å©
	public boolean loginCheck(shopDTO dto);
	// 02. È¸¿ø ·Î±×ÀÎ Á¤º¸
	public List<shopDTO> viewMember() throws Exception;
	// 03. È¸¿ø ·Î±×¾Æ¿ô
	public void logout(HttpSession session);
	
	// 01. °¡ÀÔ ¾ÆÀÌµð Áßº¹ Ã¼Å©
	public int idCheck(String userId);
	// 02. °¡ÀÔ 
	public void signUp(shopDTO dto);
	 
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
}
