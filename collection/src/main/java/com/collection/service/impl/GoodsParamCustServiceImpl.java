package com.collection.service.impl;

import com.collection.dao.GoodsParamCustDao;
import com.collection.eo.GoodsParamCust;
import com.collection.service.GoodsParamCustService;
import com.collection.util.PageUtil;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsParamCustServiceImpl implements GoodsParamCustService {

    @Autowired
    private GoodsParamCustDao goodsParamCustDao;

    public Integer addGoodsParamCust(GoodsParamCust goodsParamCust) {
        goodsParamCust.setCreateTime(new Date());
        return goodsParamCustDao.addGoodsParamCust(goodsParamCust);
    }

    public Integer deleteGoodsParamCustByGroup(Integer[] id) {
        return goodsParamCustDao.deleteGoodsParamCustByGroup(id);
    }

    public Integer updateGoodsParamCust(GoodsParamCust goodsParamCust) {
        return goodsParamCustDao.updateGoodsParamCust(goodsParamCust);
    }

    public Integer deleteGoodsParamCustById(Integer id) {
        return goodsParamCustDao.deleteGoodsParamCustById(id);
    }

    public List<GoodsParamCust> selectGoodsParamCust(GoodsParamCust goodsParamCust) {
        return goodsParamCustDao.selectGoodsParamCust(goodsParamCust);
    }

    public List<GoodsParamCust> queryGoodsParamCust(GoodsParamCust goodsParamCust) {
        return goodsParamCustDao.queryGoodsParamCust(goodsParamCust);
    }

    public List<GoodsParamCust> selectGoodsParamCustByGoodsId(Integer goodsId) {
        return goodsParamCustDao.selectGoodsParamCustByGoodsId(goodsId);
    }
}
