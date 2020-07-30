package com.project.shoppingweb.service;

import java.util.List;
import javax.servlet.http.HttpSession;
import com.project.shoppingweb.bean.*;

public interface shopService {

	public boolean loginCheck(shopDTO dto, HttpSession session);

	// 02. ȸ�� �α��� ����
	public List<shopDTO> viewMember() throws Exception;
	// 03. ȸ�� �α׾ƿ�


	// 02. 회원 정보
	public List<shopDTO> memInfo(String userId);

	// 03. 로그아웃

	public void logout(HttpSession session);


	// 01. 아이디 중복 체크

	public int idCheck(String userId);

	// 02. 회원 가입

	public void signUp(shopDTO dto);

	// 패스워드 체크
	public int passCheck(shopDTO dto);

	// 회원 탈퇴
	public void secession(shopDTO dto, HttpSession session);

}
