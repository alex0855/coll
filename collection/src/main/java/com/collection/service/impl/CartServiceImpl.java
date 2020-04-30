package com.collection.service.impl;

import com.collection.dao.CartDao;
import com.collection.eo.Cart;
import com.collection.eo.Standard;
import com.collection.eo.User;
import com.collection.service.CartService;
import com.collection.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private StandardService standardService;

    public Integer addCart(Cart cart) {
        cart.setCreateTime(new Date());
        if (cart.getGoods()!= null) {
            Cart selectCart = new Cart();
            selectCart.setUser(cart.getUser());
            selectCart.setGoods(cart.getGoods());
            selectCart.setStandard(cart.getStandard());
            List<Cart> cartList = selectCart(selectCart);
            if (cartList.size() > 0) {
                Cart updateCart = cartList.get(0);
                updateCart.setGoodsNumber(updateCart.getGoodsNumber()+1);
                BigDecimal goodsNumber = new BigDecimal(updateCart.getGoodsNumber().toString());
                updateCart.setGoodsAmount(goodsNumber.multiply(updateCart.getStandard().getTradePrice()));
                return updateCart(updateCart);
            } else {
                cart.setGoodsNumber(1);
                Standard standard = standardService.selectStandardById(cart.getStandard().getId());
                cart.setGoodsAmount(standard.getTradePrice());
                return cartDao.addCart(cart);
            }
        }
        return 0;
    }

    public Integer updateCart(Cart cart) {
        return cartDao.updateCart(cart);
    }

    public Integer deleteCartById(Integer id) {
        return cartDao.deleteCartById(id);
    }

    public Integer deleteCartByGroup(Integer[] id) {
        return cartDao.deleteCartByGroup(id);
    }

    public List<Cart> selectCart(Cart cart) {
        return cartDao.selectCart(cart);
    }

    public List<Cart> queryCart(Cart cart) {
        return cartDao.queryCart(cart);
    }

    public Cart selectCartById(Integer id) {
        return cartDao.selectCartById(id);
    }

    public List<Cart> UserCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        List<Cart> cartList = selectCart(cart);
        return cartList;
    }
}
