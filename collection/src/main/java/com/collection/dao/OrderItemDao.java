package com.collection.dao;

import com.collection.eo.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderItemDao {
    //添加
    public Integer addOrderItem(OrderItem orderItem);

    //修改
    public Integer updateOrderItem(OrderItem orderItem);

    //删除
    public Integer deleteOrderItemById(Integer id);

    //批量删除
    public Integer deleteOrderItemByGroup(Integer[] id);

    //精确查询
    public List<OrderItem> selectOrderItem(OrderItem orderItem);

    //模糊查询
    public List<OrderItem> queryOrderItem(OrderItem orderItem);

    public OrderItem selectOrderItemById(@Param("id") Integer id);

    public List<OrderItem> selectOrderItemByOrderId(@Param("orderId") Integer id);
}
