package com.project.shoppingweb.service;

import java.util.List;

import com.project.shoppingweb.bean.*;;

public interface ProductService {
	List<ProductDTO> listProduct(String cate01Id);

	ProductDTO detailProduct(int product_id);

	String fileInfo(int product_id);

	void updateProduct(ProductDTO dto);

	void deleteProduct(int product_id);

	void insertProduct(ProductDTO dto);

	List<ProductDTO> cate01List();

	List<ProductDTO> cateCheck(String cate01Id);

	List<ProductDTO> search(String result);

	List<ProductDTO> productDetail(String product_id);
}
