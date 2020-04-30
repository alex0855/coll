package com.collection.eo;

import org.springframework.stereotype.Component;

@Component
public class GoodsParam extends BaseEo{

    private String goodsParamName;

    public String getGoodsParamName() {
        return goodsParamName;
    }

    public void setGoodsParamName(String goodsParamName) {
        this.goodsParamName = goodsParamName;
    }

}
