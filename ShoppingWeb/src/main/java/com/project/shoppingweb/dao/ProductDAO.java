package com.project.shoppingweb.dao;

import java.util.List;
 
import com.project.shoppingweb.bean.*;
 
public interface ProductDAO {
    
    List<ProductDTO> listProduct(String cate02Id);
    ProductDTO detailProduct(int product_id);
    void updateProduct(ProductDTO dto);
    void deleteProduct(int product_id);
    void insertProduct(ProductDTO dto);
    String fileInfo(int product_id);
	List<ProductDTO> cate01List();
	List<ProductDTO> cateCheck(String cate01Id);
}

