package com.collection.eo;

import org.springframework.stereotype.Component;

@Component
public class GoodsParamCust extends BaseEo {

    private Integer id;
    private Integer goodsId;
    private Integer goodsParamId;
    private String goodsParamName;
    private String detail;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsParamId() {
        return goodsParamId;
    }

    public void setGoodsParamId(Integer goodsParamId) {
        this.goodsParamId = goodsParamId;
    }

    public String getGoodsParamName() {
        return goodsParamName;
    }

    public void setGoodsParamName(String goodsParamName) {
        this.goodsParamName = goodsParamName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "GoodsParamCustDao{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", goodsParamId=" + goodsParamId +
                ", goodsParamName='" + goodsParamName + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
