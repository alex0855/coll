package com.collection.vo;

import com.collection.eo.*;

import java.util.List;

public class GoodsDetailVo {
    private Goods goods;
    private GoodsImage goodsImage;
    private GoodsTitle goodsTitle;
    private List<GoodsParamCust> goodsParamCustList;
    private List<Standard> standardList;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
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

    public List<GoodsParamCust> getGoodsParamCustList() {
        return goodsParamCustList;
    }

    public void setGoodsParamCustList(List<GoodsParamCust> goodsParamCustList) {
        this.goodsParamCustList = goodsParamCustList;
    }

    public List<Standard> getStandardList() {
        return standardList;
    }

    public void setStandardList(List<Standard> standardList) {
        this.standardList = standardList;
    }

    @Override
    public String toString() {
        return "GoodsDetailVo{" +
                "goods=" + goods +
                ", goodsImage=" + goodsImage +
                ", goodsTitle=" + goodsTitle +
                ", goodsParamCustList=" + goodsParamCustList +
                ", standardList=" + standardList +
                '}';
    }
}
