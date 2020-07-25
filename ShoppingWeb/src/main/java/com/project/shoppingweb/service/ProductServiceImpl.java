package com.project.shoppingweb.service;
import java.util.List;
 
import javax.inject.Inject;
 
import org.springframework.stereotype.Service;

import com.project.shoppingweb.bean.*;
import com.project.shoppingweb.dao.*;
 
@Service
public class ProductServiceImpl implements ProductService {
 
    //Service에서는 model(DAO)를 받으므로 의존성을 주입해야한다.
    @Inject
    ProductDAO productDao;
    
    
    @Override
    public List<ProductDTO> listProduct() {
        return productDao.listProduct(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }


	@Override
	public ProductDTO detailProduct(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String fileInfo(int product_id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}
}