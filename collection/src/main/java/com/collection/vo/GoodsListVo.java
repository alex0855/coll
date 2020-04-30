package com.collection.vo;

import com.collection.eo.Goods;
import com.collection.eo.GoodsImage;
import com.collection.eo.GoodsTitle;

public class GoodsListVo {

    private Goods goods;
    private GoodsImage goodsImage;
    private GoodsTitle goodsTitle;

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

    @Override
    public String toString() {
        return "GoodsListVo{" +
                "goods=" + goods +
                ", goodsImage=" + goodsImage +
                ", goodsTitle=" + goodsTitle +
                '}';
    }
}
