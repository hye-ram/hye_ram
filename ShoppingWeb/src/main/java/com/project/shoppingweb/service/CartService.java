package com.project.shoppingweb.service;

import java.util.List;
 
import com.project.shoppingweb.bean.*;
 
public interface CartService {
    List<CartDTO> cartMoney();
    void insert(CartDTO dto);
    List<CartDTO> listCart(String userid);
    void delete(int cart_id);
    void deleteAll(String userid);
    void update(int cart_id);
    int sumMoney(String userid);
    int countCart(String userid, int product_id);
    void updateCart(CartDTO dto);
    void modifyCart(CartDTO dto);
}
