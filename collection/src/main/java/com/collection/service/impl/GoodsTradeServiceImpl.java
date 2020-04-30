package com.collection.service.impl;

import com.collection.dao.GoodsTradeDao;
import com.collection.eo.GoodsTrade;
import com.collection.service.GoodsTitleService;
import com.collection.service.GoodsTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsTradeServiceImpl  implements GoodsTradeService {
    @Autowired
    private GoodsTradeDao goodsTradeDao;

    public Integer addGoodsTrade(GoodsTrade goodsTrade) {
        goodsTrade.setCreateTime(new Date());
        return goodsTradeDao.addGoodsTrade(goodsTrade);
    }

    public Integer updateGoodsTrade(GoodsTrade goodsTrade) {
        return goodsTradeDao.updateGoodsTrade(goodsTrade);
    }

    public Integer deleteGoodsTradeById(Integer id) {
        return goodsTradeDao.deleteGoodsTradeById(id);
    }

    public Integer deleteGoodsTradeByGroup(Integer[] id) {
        return goodsTradeDao.deleteGoodsTradeByGroup(id);
    }

    public List<GoodsTrade> selectGoodsTrade(GoodsTrade goodsTrade) {
        return goodsTradeDao.selectGoodsTrade(goodsTrade);
    }

    public List<GoodsTrade> queryGoodsTrade(GoodsTrade goodsTrade) {
        return goodsTradeDao.queryGoodsTrade(goodsTrade);
    }
}
