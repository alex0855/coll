package com.collection.service;

import com.collection.eo.OrderItem;

import java.util.List;

public interface OrderItemService {
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

    public OrderItem selectOrderItemById(Integer id);

    public List<OrderItem> selectOrderItemByOrderId(Integer orderId);
}
