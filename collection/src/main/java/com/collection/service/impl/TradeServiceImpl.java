package com.collection.service.impl;

import com.collection.dao.CartDao;
import com.collection.eo.Order;
import com.collection.service.TradeService;
import com.collection.vo.AlipayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TradeServiceImpl implements TradeService {

    public AlipayVo createAlipayVo(Order order) {
        AlipayVo alipayVo = new AlipayVo();
        alipayVo.setOut_trade_no(order.getOrderNumber());
        if (order.getOrderAmount() == null || order.getOrderAmount() == (BigDecimal.ZERO)) {
            alipayVo.setTotal_amount("0.01");
        }else {
            alipayVo.setTotal_amount(order.getOrderAmount().toString());
        }
        alipayVo.setSubject("collection_trade_order");
        alipayVo.setProduct_code("FAST_INSTANT_TRADE_PAY");
        return alipayVo;
    }
}
