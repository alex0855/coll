package com.collection.controller;

import com.collection.eo.Order;
import com.collection.eo.OrderItem;
import com.collection.eo.User;
import com.collection.service.OrderItemService;
import com.collection.service.OrderService;
import com.collection.util.ServerResponse;
import com.collection.vo.CreateOrderVo;
import com.collection.vo.OrderCenterVo;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderCtrl {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping(value = "/center")
    public String center(HttpServletRequest request, Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            List<OrderCenterVo> orderCenterVoList = orderService.orderCenter(user);
            model.addAttribute("order",orderCenterVoList);
        }
        return "/front/dingdanzhongxin";
    }

    @RequestMapping(value = "/detail/{orderId}")
    public String detail(@PathVariable("orderId") Integer orderId, HttpServletRequest request, Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            CreateOrderVo createOrderVo = orderService.orderCenterDetail(user,orderId);
            ServerResponse<CreateOrderVo> response = ServerResponse.createBySuccess(createOrderVo);
            model.addAttribute("context",response);
            return "/front/dingdanxiangqing";
        }
    }

    @RequestMapping(value = "/cancelPage")
    public String cancelPage(HttpServletRequest request,Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            List<OrderCenterVo> orderCenterVoList = orderService.orderCenter(user);
            model.addAttribute("order",orderCenterVoList);
        }
        return "/front/dingdancancel";
    }

    @RequestMapping(value = "/cancel/{orderId}")
    public String cancelPage(@PathVariable("orderId") Integer id, HttpServletRequest request,Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            if (orderService.orderCancel(user, id)) {
                return "redirect:/order/cancelPage";
            }
        }
        return "redirect:/index";
    }

    @RequestMapping(value = "/select")
    public String orderSelect(Order order, Page<Order> page, Model model) {
        if (order != null && order.getOrderNumber()!=null&&order.getOrderNumber().equals("")) {
            order.setOrderNumber(null);
        }
            ServerResponse response = orderService.selectOrderForm(order, page);
          model.addAttribute("context",response);
          return "/forms/orderForm";
    }

    @RequestMapping(value = "/pay/select")
    public String paySelect(Order order, Page<Order> page, Model model) {
        if (order != null && order.getOrderNumber()!=null&&order.getOrderNumber().equals("")) {
            order.setOrderNumber(null);
        }
        if (order != null && order.getOrderTradeId()!=null&&order.getOrderTradeId().equals("")) {
            order.setOrderTradeId(null);
        }
        ServerResponse response = orderService.selectPay(order, page);
        model.addAttribute("context",response);
        return "/forms/payForm";
    }
}
