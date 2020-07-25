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
	
	
	
	// 01. �Խñ� �ۼ�
	@Override
	public void create(shopDTO dto) throws Exception {
		sqlSession.insert("board.insert", dto);
	}
	// 02. �Խñ� �󼼺���
	@Override
	public shopDTO read(int bno) throws Exception {
		 return sqlSession.selectOne("board.view", bno);
	}
	// 03. �Խñ� ����
	@Override
	public void update(shopDTO dto) throws Exception {
		sqlSession.update("board.updateArticle", dto);
	}
	// 04. �Խñ� ����
	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.deleteArticle",bno);
	}
	// 05. �Խñ� ��ü ���
	@Override
	public List<shopDTO> listAll() {
		// TODO Auto-generated method stub
		 return sqlSession.selectList("board.listAll");
	}
	// 06. �Խñ� ��ȸ
	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}


	
	
