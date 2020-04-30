package com.collection.eo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderItem extends BaseEo {
    private Order order;
    private UserAddress userAddress;
    private User buyer;
    private User seller;
    private Goods goods;
    private Integer goodsNumber;
    private Standard standard;
    private BigDecimal goodsTradePrice;
    private BigDecimal goodsAmount;
    private Byte tradeStatus;
    private String remark;

    private GoodsImage goodsImage;

    private GoodsTitle goodsTitle;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public BigDecimal getGoodsTradePrice() {
        return goodsTradePrice;
    }

    public void setGoodsTradePrice(BigDecimal goodsTradePrice) {
        this.goodsTradePrice = goodsTradePrice;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Byte getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Byte tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public GoodsImage getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(GoodsImage goodsImage) {
        this.goodsImage = goodsImage;
    }

    public GoodsTitle getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(GoodsTitle goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "order=" + order +
                ", userAddress=" + userAddress +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", goods=" + goods +
                ", goodsNumber=" + goodsNumber +
                ", standard=" + standard +
                ", goodsTradePrice=" + goodsTradePrice +
                ", goodsAmount=" + goodsAmount +
                ", tradeStatus=" + tradeStatus +
                ", remark='" + remark + '\'' +
                '}';
    }
}
