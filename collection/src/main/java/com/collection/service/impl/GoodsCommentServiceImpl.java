package com.collection.service.impl;

import com.collection.dao.GoodsCommentDao;
import com.collection.eo.GoodsComment;
import com.collection.service.GoodsCommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class GoodsCommentServiceImpl implements GoodsCommentService {
    @Autowired
    private GoodsCommentDao goodsCommentDao;

    public Integer addGoodsComment(GoodsComment goodsComment) {
        goodsComment.setCreateTime(new Date());
        return goodsCommentDao.addGoodsComment(goodsComment);
    }

    public Integer updateGoodsComment(GoodsComment goodsComment) {
        return goodsCommentDao.updateGoodsComment(goodsComment);
    }

    public Integer deleteGoodsCommentById(Integer id) {
        return goodsCommentDao.deleteGoodsCommentById(id);
    }

    public Integer deleteGoodsCommentByGroup(Integer[] id) {
        return goodsCommentDao.deleteGoodsCommentByGroup(id);
    }

    public List<GoodsComment> selectGoodsComment(GoodsComment goodsComment) {
        return goodsCommentDao.selectGoodsComment(goodsComment);
    }

    public List<GoodsComment> queryGoodsComment(GoodsComment goodsComment) {
        return goodsCommentDao.queryGoodsComment(goodsComment);
    }

    public GoodsComment selectGoodsCommentById(Integer id) {
        return goodsCommentDao.selectGoodsCommentById(id);
    }
}
