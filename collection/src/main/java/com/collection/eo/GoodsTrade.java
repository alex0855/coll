package com.collection.eo;

import org.springframework.stereotype.Component;

@Component
public class GoodsTrade extends BaseEo {

    private Integer goodsId;
    private Integer standardId;
    private Integer standardClassId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStandardId() {
        return standardId;
    }

    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }

    public Integer getStandardClassId() {
        return standardClassId;
    }

    public void setStandardClassId(Integer standardClassId) {
        this.standardClassId = standardClassId;
    }

    @Override
    public String toString() {
        return "GoodsTrade{" +
                "goodsId=" + goodsId +
                ", standardId=" + standardId +
                ", standardClassId=" + standardClassId +
                '}';
    }
}
