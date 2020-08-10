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
    public List<ProductDTO> listProduct(String cate01Id) {
        return productDao.listProduct(cate01Id); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }
    
    @Override
    public List<ProductDTO> listProduct_group(String cate02Id) {
        return productDao.listProduct_group(cate02Id); //데이터베이스에 저장된 상품 리스트를 리턴한다.
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
		productDao.insertProduct(dto);
		
	}
	
	@Override
    public List<ProductDTO> cate01List() {
        return productDao.cate01List(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }
	
	@Override
    public List<ProductDTO>  cateCheck(String cate01Id) {
        return productDao.cateCheck(cate01Id); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }


	@Override
	public List<ProductDTO> search(String result) {
		return productDao.search(result);
	}
	
	@Override
	public List<ProductDTO> productDetail(String product_id) {
		return productDao.productDetail(product_id);
	}


	@Override
	public List<ProductDTO> listCate(String cate01Id) {
		return productDao.listCate(cate01Id); 
	}
}