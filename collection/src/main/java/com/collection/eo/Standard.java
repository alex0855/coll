package com.collection.eo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Standard extends BaseEo{

    private Goods goods;
    private String standardName;
    private BigDecimal tradePrice;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "goods=" + goods +
                ", standardName='" + standardName + '\'' +
                ", tradePrice=" + tradePrice +
                '}';
    }
}
