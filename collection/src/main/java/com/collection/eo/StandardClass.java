package com.collection.eo;

import org.springframework.stereotype.Component;

@Component
public class StandardClass extends BaseEo {

    private Integer goodsId;
    private String standardClassName;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getStandardClassName() {
        return standardClassName;
    }

    public void setStandardClassName(String standardClassName) {
        this.standardClassName = standardClassName;
    }

    @Override
    public String toString() {
        return "StandardClass{" +
                "goodsId=" + goodsId +
                ", standardClassName='" + standardClassName + '\'' +
                '}';
    }
}
