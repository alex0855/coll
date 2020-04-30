package com.collection.dao;

import com.collection.eo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {
    //添加
    public Integer addOrder(Order order);

    //修改
    public Integer updateOrder(Order order);

    //删除
    public Integer deleteOrderById(Integer id);

    //批量删除
    public Integer deleteOrderByGroup(Integer[] id);

    //精确查询
    public List<Order> selectOrder(Order order);

    //模糊查询
    public List<Order> queryOrder(Order order);

    public Order selectOrderById(@Param("id")Integer id);

    public Integer updateByOrderNumber(Order order);

    //查询交易号
    public List<Order> selectPay(Order order);
}
