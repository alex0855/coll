package com.collection.service;

import com.collection.eo.Order;
import com.collection.vo.AlipayVo;

public interface TradeService {

    public AlipayVo createAlipayVo(Order order);
}
