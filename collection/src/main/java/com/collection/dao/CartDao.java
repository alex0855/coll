package com.collection.dao;

import com.collection.eo.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartDao {

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

}
