package com.collection.service.impl;

import com.collection.dao.GoodsTitleDao;
import com.collection.eo.GoodsTitle;
import com.collection.service.GoodsTitleService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsTitleSerciceImpl implements GoodsTitleService {
    @Autowired
    private GoodsTitleDao goodsTitleDao;

    public Integer addGoodsTitle(GoodsTitle goodsTitle) {
        goodsTitle.setCreateTime(new Date());
        return goodsTitleDao.addGoodsTitle(goodsTitle);
    }

    public Integer updateGoodsTitle(GoodsTitle goodsTitle) {
        return goodsTitleDao.updateGoodsTitle(goodsTitle);
    }

    public Integer deleteGoodsTitleById(Integer id) {
        return goodsTitleDao.deleteGoodsTitleById(id);
    }

    public Integer deleteGoodsTitleByGroup(Integer[] id) {
        return goodsTitleDao.deleteGoodsTitleByGroup(id);
    }

    public List<GoodsTitle> selectGoodsTitle(GoodsTitle goodsTitle) {
        return goodsTitleDao.selectGoodsTitle(goodsTitle);
    }

    public List<GoodsTitle> queryGoodsTitle(GoodsTitle goodsTitle) {
        return goodsTitleDao.queryGoodsTitle(goodsTitle);
    }

    public List<GoodsTitle> selectListGoodsTitle(Integer goodsId) {
        return goodsTitleDao.selectListByGoodsId(goodsId);
    }

    public GoodsTitle selectGoodsTitleByGoodsId(Integer goodsId) {
        return goodsTitleDao.selectByGoodsId(goodsId);
    }

    public GoodsTitle selectGoodsTitleById(Integer id) {
        return goodsTitleDao.selectGoodsTitleById(id);
    }
}
