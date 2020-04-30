package com.collection.service;

import com.collection.eo.Cart;
import com.collection.eo.Order;
import com.collection.eo.User;
import com.collection.util.ServerResponse;
import com.collection.vo.CreateOrderVo;
import com.collection.vo.OrderCenterVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {
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

    public Order selectOrderById(Integer id);

    //生成订单
    public CreateOrderVo createOrder(User user, List<Cart> cart);

    //提交订单
    public Order commitOrder(User user,CreateOrderVo createOrderVo);

    //订单中心查询订单列表
    public List<OrderCenterVo> orderCenter(User user);

    //订单中心的订单列表查询订单详情
    public CreateOrderVo orderCenterDetail(User user,Integer orderId);

    //取消订单
    public Boolean orderCancel(User user,Integer orderId);

    //根据订单号码更新
    public Integer updateByOrderNumber(Order order);

    //精确查询
    public ServerResponse<PageInfo<Order>> selectOrderForm(Order order, Page page);

    //模糊查询
    public ServerResponse<PageInfo<Order>> queryOrderForm(Order order,Page page);

    //查询交易
    public ServerResponse<PageInfo<Order>> selectPay(Order order,Page page);
}
