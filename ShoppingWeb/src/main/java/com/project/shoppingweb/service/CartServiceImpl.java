package com.project.shoppingweb.service;

import java.util.List;
 
import javax.inject.Inject;
 
import org.springframework.stereotype.Service;

import com.project.shoppingweb.bean.*;
import com.project.shoppingweb.dao.*;


@Service //Service 단이라는 것을 표시
public class CartServiceImpl implements CartService {
    
    @Inject //dao를 사용해야하기 때문에 @Inject로 의존성 부여
    CartDAO cartDao;
    
    @Override
    public List<CartDTO> cartMoney() {
        return null;
    }
    @Override
    public void insert(CartDTO dto) {
        cartDao.insert(dto);
    }
 
    @Override
    public List<CartDTO> listCart(String userid) {
        return cartDao.listCart(userid);
    }
 
    @Override
    public void delete(int cart_id) {
        cartDao.delete(cart_id);
    }
 
    @Override
    public void deleteAll(String userid) {
        cartDao.deleteAll(userid);
    }
 
    @Override
    public void update(int cart_id) {
        // TODO Auto-generated method stub
 
    }
 
    @Override
    public int sumMoney(String userid) {
        return cartDao.sumMoney(userid);
    }
 
    @Override
    public int countCart(String userid, int product_id) {
        // TODO Auto-generated method stub
        return 0;
    }
 
    @Override
    public void updateCart(CartDTO dto) {
        // TODO Auto-generated method stub
 
    }
 
    @Override
    public void modifyCart(CartDTO dto) {
        cartDao.modifyCart(dto);
    }
 
}