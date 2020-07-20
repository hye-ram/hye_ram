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
	
	
	// 01. ȸ�� �α��� üũ
	
	 public boolean loginCheck(shopDTO dto);
	 
	 // 02. ȸ�� �α��� ���� 
	 public shopDTO viewMember(shopDTO dto); 
	 // 03. ȸ�� �α׾ƿ�
	 public void logout(HttpSession session);
	 
	// 01. �Խñ� �ۼ�
		public void create(shopDTO dto) throws Exception;
		// 02. �Խñ� �󼼺���
		public shopDTO read(int bno) throws Exception;
		// 03. �Խñ� ����
		public void update(shopDTO dto) throws Exception;
		// 04. �Խñ� ����
		public void delete(int bno) throws Exception;
		// 05. �Խñ� ��ü ���
		public List<shopDTO> listAll() throws Exception;
		// 06. �Խñ� ��ȸ
		public void increaseViewcnt(int bno, HttpSession session) throws Exception;
	

}
