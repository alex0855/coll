package com.collection.eo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Component
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Cart extends BaseEo{
    private User user;
    private Goods goods;
    private Integer goodsNumber;
    private BigDecimal goodsAmount;
    private Standard standard;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "user=" + user +
                ", goods=" + goods +
                ", goodsNumber=" + goodsNumber +
                ", goodsAmount=" + goodsAmount +
                ", standard=" + standard +
                '}';
    }
}
