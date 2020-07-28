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
<<<<<<< HEAD
	
	
	// 01. �α��� üũ
=======

	// 01. 로그인 체크
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	@Override
	public boolean loginCheck(shopDTO dto) {
<<<<<<< HEAD
		String name = sqlSession.selectOne("memberMapper.loginCheck",dto);
		// �˻��� �ȵǸ� 0�� ��ȯ���ֱ� ������ 0�� ���ؼ� ���̸� false, Ʋ���� true�� ��ȯ
		return (Integer.parseInt(name)==0)?false:true;
=======
		String name = sqlSession.selectOne("member.loginCheck", dto);
		return (Integer.parseInt(name) == 0) ? false : true;
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	}
<<<<<<< HEAD
	// 02. ȸ�� �α��� ����
=======

	// 02. 회원 정보 조회
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	@Override
<<<<<<< HEAD
	public List<shopDTO> viewMember() throws Exception {
		return sqlSession.selectList("testMapper.listAll");
    }
	// 03. ȸ�� �α׾ƿ�
=======
	public List<shopDTO> memInfo(String userId) {
		return sqlSession.selectList("member.memInfo", userId);
	}

	// 03. 로그아웃
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
<<<<<<< HEAD
	
	
	// 01. ���� ���̵� �ߺ� üũ
=======

	// 01. 아이디 중복 체크
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	@Override
	public int idCheck(String userId) {
		int result = sqlSession.selectOne("member.idCheck", userId);
		return result;
	}
<<<<<<< HEAD
	// 02. ����
=======

	// 02. 회원가입
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	@Override
	public void signUp(shopDTO dto) {
<<<<<<< HEAD
		System.out.println("ȸ������");
		sqlSession.insert("memberMapper.signUp", dto);
=======
		sqlSession.insert("member.signUp", dto);
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git
	}
<<<<<<< HEAD
	
	

=======

	// 01. �Խñ� �ۼ�
	@Override
	public void create(boardDTO dto) throws Exception {
		sqlSession.insert("board.insert", dto);
	}

	// 02. �Խñ� �󼼺���
	@Override
	public boardDTO read(int bno) throws Exception {
		return sqlSession.selectOne("board.view", bno);
	}

	// 03. �Խñ� ����
	@Override
	public void update(boardDTO dto) throws Exception {
		sqlSession.update("board.updateArticle", dto);
	}

	// 04. �Խñ� ����
	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.deleteArticle", bno);
	}

	// 05. �Խñ� ��ü ���
	@Override
	public List<boardDTO> listAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.listAll");
	}

	// 06. �Խñ� ��ȸ
	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub

	}

	// 패스워드 체크
	public int passCheck(shopDTO dto) {
		int result = Integer.parseInt((String) sqlSession.selectOne("member.loginCheck", dto));
		return result;
	}

	// 회원탈퇴
	public void secession(shopDTO dto, HttpSession session) {
		sqlSession.delete("member.secession", dto);
		// 세션 삭제
		session.invalidate();
	}
>>>>>>> branch 'master' of https://github.com/hye-ram/hye_ram.git

}
