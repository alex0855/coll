package com.collection.service;

import com.collection.eo.Cart;
import com.collection.eo.Standard;
import com.collection.eo.User;

import java.util.List;

public interface CartService {
    //添加
    public Integer addCart(Cart cart);

    //修改
    public Integer updateCart(Cart cart);

    //删除
    public Integer deleteCartById(Integer id);

    //批量删除
    public Integer deleteCartByGroup(Integer[] id);

    //精确查询
    public List<Cart> selectCart(Cart cart);

    //模糊查询
    public List<Cart> queryCart(Cart cart);

    public Cart selectCartById(Integer id);

    //用户购物车
    public List<Cart> UserCart(User user);
    
}
