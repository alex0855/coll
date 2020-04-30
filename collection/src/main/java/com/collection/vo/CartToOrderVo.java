package com.collection.vo;

import com.collection.eo.Cart;

import java.util.List;

public class CartToOrderVo {
    private List<Cart> cartList;

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
