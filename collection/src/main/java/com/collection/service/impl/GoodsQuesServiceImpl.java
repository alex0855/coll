package com.collection.service.impl;

import com.collection.dao.GoodsQuesDao;
import com.collection.eo.GoodsQues;
import com.collection.service.GoodsQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsQuesServiceImpl implements GoodsQuesService {
    @Autowired
    private GoodsQuesDao goodsQuesDao;

    public Integer addGoodsQues(GoodsQues goodsQues) {
        goodsQues.setCreateTime(new Date());
        return goodsQuesDao.addGoodsQues(goodsQues);
    }

    public Integer updateGoodsQues(GoodsQues goodsQues) {
        return goodsQuesDao.updateGoodsQues(goodsQues);
    }

    public Integer deleteGoodsQuesById(Integer id) {
        return goodsQuesDao.deleteGoodsQuesById(id);
    }

    public Integer deleteGoodsQuesByGroup(Integer[] id) {
        return goodsQuesDao.deleteGoodsQuesByGroup(id);
    }

    public List<GoodsQues> selectGoodsQues(GoodsQues goodsQues) {
        return goodsQuesDao.selectGoodsQues(goodsQues);
    }

    public List<GoodsQues> queryGoodsQues(GoodsQues goodsQues) {
        return goodsQuesDao.queryGoodsQues(goodsQues);
    }

    public GoodsQues selectGoodsQuesById(Integer id) {
        return goodsQuesDao.selectGoodsQuesById(id);
    }
}
