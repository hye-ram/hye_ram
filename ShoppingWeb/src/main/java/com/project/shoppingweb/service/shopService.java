package com.project.shoppingweb.service;

import java.util.List;
import javax.servlet.http.HttpSession;
import com.project.shoppingweb.bean.*;

public interface shopService {
	
	// 01. ȸ�� �α��� üũ
	public boolean loginCheck(shopDTO dto, HttpSession session);
	// 02. ȸ�� �α��� ����
	public List<shopDTO> viewMember() throws Exception;
	// 03. ȸ�� �α׾ƿ�
	public void logout(HttpSession session);
	
	// 01. ���� ���̵� �ߺ� üũ
	public int idCheck(String userId);
	// 02. ���� 
	public void signUp(shopDTO dto);
	
	
}
