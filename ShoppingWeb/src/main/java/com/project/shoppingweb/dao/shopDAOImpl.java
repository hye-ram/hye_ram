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
	
	@Override
	public boolean loginCheck(shopDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public shopDTO viewMember(shopDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(shopDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public shopDTO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(shopDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<shopDTO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}
}


	
	
