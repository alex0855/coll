package com.collection.service.impl;

import com.collection.dao.OrderItemDao;
import com.collection.eo.OrderItem;
import com.collection.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemDao orderItemDao;

    public Integer addOrderItem(OrderItem orderItem) {
        orderItem.setCreateTime(new Date());
        return orderItemDao.addOrderItem(orderItem);
    }

    public Integer updateOrderItem(OrderItem orderItem) {
        return orderItemDao.updateOrderItem(orderItem);
    }

    public Integer deleteOrderItemById(Integer id) {
        return orderItemDao.deleteOrderItemById(id);
    }

    public Integer deleteOrderItemByGroup(Integer[] id) {
        return orderItemDao.deleteOrderItemByGroup(id);
    }

    public List<OrderItem> selectOrderItem(OrderItem orderItem) {
        return orderItemDao.selectOrderItem(orderItem);
    }

    public List<OrderItem> queryOrderItem(OrderItem orderItem) {
        return orderItemDao.queryOrderItem(orderItem);
    }

    public OrderItem selectOrderItemById(Integer id) {
        return orderItemDao.selectOrderItemById(id);
    }

    public List<OrderItem> selectOrderItemByOrderId(Integer orderId) {
        return orderItemDao.selectOrderItemByOrderId(orderId);
    }
}
