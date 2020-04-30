package com.collection.vo;

import com.collection.eo.GoodsImage;
import com.collection.eo.Order;
import com.collection.eo.OrderItem;

public class OrderCenterVo {

    private Order order;

    private OrderItem ordreItem;

    private GoodsImage goodsImage;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem getOrdreItem() {
        return ordreItem;
    }

    public void setOrdreItem(OrderItem ordreItem) {
        this.ordreItem = ordreItem;
    }

    public GoodsImage getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(GoodsImage goodsImage) {
        this.goodsImage = goodsImage;
    }
}
