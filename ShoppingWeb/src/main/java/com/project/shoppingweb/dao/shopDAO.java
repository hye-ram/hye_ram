package com.project.shoppingweb.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
import org.springframework.stereotype.Repository;
import com.project.shoppingweb.bean.*;

@Repository
public interface shopDAO {

	// 01. ȸ�� �α��� üũ
	public boolean loginCheck(shopDTO dto);
<<<<<<< HEAD
	// 02. ȸ�� �α��� ����
	public List<shopDTO> viewMember() throws Exception;
=======

	// 02. ȸ�� �α��� ����
	public List<shopDTO> memInfo(String userId);

>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	// 03. ȸ�� �α׾ƿ�
	public void logout(HttpSession session);
<<<<<<< HEAD
	
=======

>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	// 01. ���� ���̵� �ߺ� üũ
	public int idCheck(String userId);
<<<<<<< HEAD
	// 02. ���� 
=======

	// 02. ����
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	public void signUp(shopDTO dto);
<<<<<<< HEAD
	


=======

	// 패스워드 체크
	public int passCheck(shopDTO dto);

	// 회원탈퇴
	public void secession(shopDTO dto, HttpSession session);

	// 01. �Խñ� �ۼ�
	public void create(boardDTO dto) throws Exception;

	// 02. �Խñ� �󼼺���
	public boardDTO read(int bno) throws Exception;

	// 03. �Խñ� ����
	public void update(boardDTO dto) throws Exception;

	// 04. �Խñ� ����
	public void delete(int bno) throws Exception;

	// 05. �Խñ� ��ü ���
	public List<boardDTO> listAll();

	// 06. �Խñ� ��ȸ
	public void increaseViewcnt(int bno, HttpSession session) throws Exception;
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
}
