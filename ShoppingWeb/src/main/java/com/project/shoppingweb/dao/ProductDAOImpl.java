package com.project.shoppingweb.dao;

import java.util.List;

import com.project.shoppingweb.bean.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.shoppingweb.bean.*;

@Repository // DB관련 객체를 스프링에서 대신 관리해주게하는 어노테이션
public class ProductDAOImpl implements ProductDAO {

	@Inject // sqlSession을 의존성을 주입해서 스프링 자체에서 객체를 생성하고 소멸시키게끔 한다.
	SqlSession sqlSession;

	@Override
	public List<ProductDTO> listProduct(String cate01Id) {
		System.out.println(cate01Id);
		if (cate01Id == null) {
			return sqlSession.selectList("product.productAll");
		} else {
			return sqlSession.selectList("product.product_list", cate01Id);
		}
	}
	
	@Override
	public void updateProduct(ProductDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int product_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertProduct(ProductDTO dto) {
		sqlSession.insert("product.insert", dto);
	}

	@Override
	public String fileInfo(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> cate01List() {
		return sqlSession.selectList("product.list_cate01");
	}

	@Override
	public List<ProductDTO> cateCheck(String cate01Id) {
		return sqlSession.selectList("product.list_cate02", cate01Id);
	}

	@Override
	public List<ProductDTO> search(String result) {
		return sqlSession.selectList("product.search", result);
	}

	@Override
	public List<ProductDTO> productDetail(String product_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.product_detail", product_id);
	}
}