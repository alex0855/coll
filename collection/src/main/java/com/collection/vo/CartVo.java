package com.collection.vo;

import com.collection.eo.Cart;
import com.collection.eo.Goods;
import com.collection.eo.GoodsImage;
import com.collection.eo.Standard;

public class CartVo {
    private GoodsImage goodsImage;
    private Cart cart;

    public GoodsImage getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(GoodsImage goodsImage) {
        this.goodsImage = goodsImage;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
