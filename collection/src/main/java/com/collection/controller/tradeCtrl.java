package com.collection.controller;

import com.collection.eo.Cart;
import com.collection.eo.Order;
import com.collection.eo.User;
import com.collection.service.CartService;
import com.collection.service.OrderService;
import com.collection.service.TradeService;
import com.collection.util.ServerResponse;
import com.collection.vo.AlipayVo;
import com.collection.vo.CartToOrderVo;
import com.collection.vo.CartVo;
import com.collection.vo.CreateOrderVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/trade")
public class tradeCtrl {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private TradeService tradeService;

    @ResponseBody
    @PostMapping(value = "/addCart")
    public String cart(HttpServletRequest request,@RequestBody CartVo cartvo) throws Exception{
        Map<String,String> map = new HashMap<String,String>();
        ObjectMapper objectMapper = new ObjectMapper();

        User user = (User)request.getAttribute("user");
        if(cartvo==null){
            map.put("url","/index");
            return objectMapper.writeValueAsString(map);
        }
        Cart cart = cartvo.getCart();
        cart.setUser(user);

        if (cart==null||cart.getUser()== null) {
            map.put("url","/user/loginPage");
            return objectMapper.writeValueAsString(map);
        }
        if (cartService.addCart(cart) > 0) {
            map.put("url","/trade/cartPage");
            return objectMapper.writeValueAsString(map);
        } else {
            map.put("url","/index");
            return objectMapper.writeValueAsString(map);
        }

    }

    @RequestMapping(value = "/cartPage")
    public String cartPage(HttpServletRequest request,Model model) {
        User user = (User) request.getAttribute("user");
        List<Cart> cartList = cartService.UserCart(user);
        ServerResponse<List<Cart>> response = ServerResponse.createBySuccess(cartList);
        model.addAttribute("context",response);
        return "/front/cart";
    }

    @RequestMapping(value = "/cartDelete/{id}")
    public String cartDelete(@PathVariable("id") Integer id) {
        if (cartService.deleteCartById(id)>0) {
            return "redirect:/trade/cartPage";
        } else {
            return "/back/500";
        }
    }

    //生成订单
    @RequestMapping(value = "/createOrder")
    public String createOrder(HttpServletRequest request, CartToOrderVo cartToOrderVo, Model model) {
        User user = (User) request.getAttribute("user");
        if(user==null){
            return "redirect:/user/loginPage";
        }

        List<Cart> cartList = cartToOrderVo.getCartList();
        if(cartList==null||cartList.size()<=0){
            return "redirect:/trade/cartPage";
        }

        CreateOrderVo createOrderVo = orderService.createOrder(user,cartList);
        ServerResponse<CreateOrderVo> response = ServerResponse.createBySuccess(createOrderVo);
        model.addAttribute("context", response);
        return "/front/orderPage";
    }

    //提交订单
    @RequestMapping(value = "/commitOrder")
    public String commitOrder(HttpServletRequest request,CreateOrderVo createOrderVo,Model model) {
        User user = (User) request.getAttribute("user");
        if(user==null){
            return "redirect:/user/loginPage";
        }
        if (createOrderVo.getOrderItemList() == null) {
            return "redirect:/index";
        } else {
            Order order = orderService.commitOrder(user, createOrderVo);
            if (order != null) {
                AlipayVo alipayVo = tradeService.createAlipayVo(order);
                model.addAttribute("alipay",alipayVo);
                return "/back/orderSuccess";
            } else {
                return "redirect:/index";
            }
        }
    }
}
