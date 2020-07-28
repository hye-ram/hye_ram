package com.project.shoppingweb.dao;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.shoppingweb.bean.*;

@Repository
public class shopDAOImpl implements shopDAO {
	

	@Inject
	private SqlSession sqlSession;
	
	
	// 01. �α��� üũ
	@Override
	public boolean loginCheck(shopDTO dto) {
		String name = sqlSession.selectOne("memberMapper.loginCheck",dto);
		// �˻��� �ȵǸ� 0�� ��ȯ���ֱ� ������ 0�� ���ؼ� ���̸� false, Ʋ���� true�� ��ȯ
		return (Integer.parseInt(name)==0)?false:true;
	}
	// 02. ȸ�� �α��� ����
	@Override
	public List<shopDTO> viewMember() throws Exception {
		return sqlSession.selectList("testMapper.listAll");
    }
	// 03. ȸ�� �α׾ƿ�
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	
	// 01. ���� ���̵� �ߺ� üũ
	@Override
	public int idCheck(String userId) {
		int result = sqlSession.selectOne("memberMapper.idCheck", userId);
		return result;
	}
	// 02. ����
	@Override
	public void signUp(shopDTO dto) {
		System.out.println("ȸ������");
		sqlSession.insert("memberMapper.signUp", dto);
	}
	
	


}


	
	
