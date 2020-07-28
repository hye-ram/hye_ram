package com.project.shoppingweb.dao;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Repository;
import com.project.shoppingweb.bean.*;

@Repository
public interface shopDAO {

	// 01. ȸ�� �α��� üũ
	public boolean loginCheck(shopDTO dto);
	// 02. ȸ�� �α��� ����
	public List<shopDTO> viewMember() throws Exception;
	// 03. ȸ�� �α׾ƿ�
	public void logout(HttpSession session);
	
	// 01. ���� ���̵� �ߺ� üũ
	public int idCheck(String userId);
	// 02. ���� 
	public void signUp(shopDTO dto);
	


}
