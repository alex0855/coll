package com.collection.service.impl;

import com.collection.dao.OrderDao;
import com.collection.eo.*;
import com.collection.service.GoodsService;
import com.collection.service.OrderItemService;
import com.collection.service.OrderService;
import com.collection.util.PageUtil;
import com.collection.util.ServerResponse;
import com.collection.vo.CreateOrderVo;
import com.collection.vo.OrderCenterVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderItemService orderItemService;

    public Integer addOrder(Order order) {
        order.setCreateTime(new Date());
        return orderDao.addOrder(order);
    }

    public Integer updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    public Integer deleteOrderById(Integer id) {
        return orderDao.deleteOrderById(id);
    }

    public Integer deleteOrderByGroup(Integer[] id) {
        return orderDao.deleteOrderByGroup(id);
    }

    public List<Order> selectOrder(Order order) {
        return orderDao.selectOrder(order);
    }

    public List<Order> queryOrder(Order order) {
        return orderDao.queryOrder(order);
    }

    public ServerResponse<PageInfo<Order>> selectOrderForm(Order order, Page page) {
        PageUtil.initPage(page);
        List<Order> orderList = orderDao.selectOrder(order);
        PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);
        ServerResponse<PageInfo<Order>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    public ServerResponse<PageInfo<Order>> queryOrderForm(Order order, Page page) {
        PageUtil.initPage(page);
        List<Order> orderList = orderDao.queryOrder(order);
        PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);
        ServerResponse<PageInfo<Order>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }


    public Order selectOrderById(Integer id) {
        return orderDao.selectOrderById(id);
    }

    //生成订单
    public CreateOrderVo createOrder(User user, List<Cart> cartList) {
        CreateOrderVo createOrderVo = new CreateOrderVo();
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();

        if (cartList==null||cartList.size() <= 0) {
            return null;
        } else {
            for (Cart cart : cartList) {
                OrderItem orderItem = new OrderItem();
                Goods goods = goodsService.selectGoodsById(cart.getGoods().getId());
                orderItem.setGoods(cart.getGoods());
                orderItem.setGoodsTitle(goods.getGoodsTitle());
                orderItem.setGoodsImage(goods.getGoodsImage());
                orderItem.setGoodsNumber(cart.getGoodsNumber());
                orderItem.setGoodsAmount(cart.getGoodsAmount());
                orderItem.setStandard(cart.getStandard());
                orderItem.setGoodsTradePrice(cart.getStandard().getTradePrice());
                orderItemList.add(orderItem);
            }
        }
        createOrderVo.setOrderItemList(orderItemList);
        return createOrderVo;
    }

    //提交订单
    public Order commitOrder(User user, CreateOrderVo createOrderVo) {
        //往订单表插入数据
        //随机生成订单号
        int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
        int r2=(int)(Math.random()*(10));
        long now = System.currentTimeMillis();//一个13位的时间戳
        String orderNumber = String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
        //创建Order
        Order order = new Order();
        order.setBuyer(user);
        order.setOrderNumber(orderNumber);
        order.setOrderAmount(createOrderVo.getOrderAmount());//订单总金额
        order.setPayAmount(createOrderVo.getOrderAmount());//交易总金额
        order.setTradeStatus((byte)0);//交易状态，0：已提交
        order.setPayStatus((byte)0);//支付状态，0：未支付
        if (addOrder(order) > 0) {
            //订单表插入成功，开始插入订单详细表
            for (OrderItem orderItem : createOrderVo.getOrderItemList()) {
                orderItem.setBuyer(user);
                orderItem.setOrder(order);
                orderItem.setTradeStatus((byte)0);//订单详情商品交易状态，0：未发货
                orderItemService.addOrderItem(orderItem);
            }
            return order;
        } else {
            return null;
        }
    }

    public List<OrderCenterVo> orderCenter(User user) {
        List<OrderCenterVo> orderCenterVoList = new ArrayList<OrderCenterVo>();
        Order selectOrder = new Order();
        selectOrder.setBuyer(user);
        List<Order> orderList = selectOrder(selectOrder);
        Collections.reverse(orderList);
        if (orderList != null) {
            for (Order order : orderList) {
                OrderCenterVo orderCenterVo = new OrderCenterVo();
                orderCenterVo.setOrder(order);
                OrderItem selectOrderItem = new OrderItem();
                selectOrderItem.setOrder(order);
                List<OrderItem> orderItemList = orderItemService.selectOrderItem(selectOrderItem);
                if (orderItemList != null) {
                    orderCenterVo.setOrdreItem(orderItemList.get(0));
                    orderCenterVo.setGoodsImage(orderItemList.get(0).getGoods().getGoodsImage());
                }
                orderCenterVoList.add(orderCenterVo);
            }
        }
        return orderCenterVoList;
    }

    public CreateOrderVo orderCenterDetail(User user, Integer orderId) {
        Order selectOrder = new Order();
        selectOrder.setId(orderId);
        CreateOrderVo createOrderVo = new CreateOrderVo();
        Order order = selectOrder(selectOrder).get(0);
        createOrderVo.setOrder(order);
        createOrderVo.setOrderAmount(order.getOrderAmount());

        List<OrderItem> orderItemList = orderItemService.selectOrderItemByOrderId(orderId);
        if (orderItemList != null) {
            for (OrderItem orderItem : orderItemList) {
                orderItem.setGoodsImage(orderItem.getGoods().getGoodsImage());
                orderItem.setGoodsTitle(orderItem.getGoods().getGoodsTitle());
            }
        }

        createOrderVo.setOrderItemList(orderItemList);
        return createOrderVo;
    }

    public Boolean orderCancel(User user, Integer orderId) {
        List<OrderItem> orderItemList = orderItemService.selectOrderItemByOrderId(orderId);
        if (orderItemList != null) {
            for (OrderItem orderItem : orderItemList) {
                if (orderItemService.deleteOrderItemById(orderItem.getId())<=0) {
                    return false;
                }
            }
        }
        if (deleteOrderById(orderId) > 0) {
            return true;
        }
        return false;
    }

    public Integer updateByOrderNumber(Order order) {
        return orderDao.updateByOrderNumber(order);
    }

    public ServerResponse<PageInfo<Order>> selectPay(Order order,Page page) {
        PageUtil.initPage(page);
        List<Order> orderList = orderDao.selectPay(order);
        PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);
        ServerResponse<PageInfo<Order>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }
}
