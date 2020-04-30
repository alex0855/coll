package com.collection.service;

import com.collection.eo.GoodsComment;

import java.util.List;

public interface GoodsCommentService {
    //添加
    public Integer addGoodsComment(GoodsComment goodsComment);

    //修改
    public Integer updateGoodsComment(GoodsComment goodsComment);

    //删除
    public Integer deleteGoodsCommentById(Integer id);

    //批量删除
    public Integer deleteGoodsCommentByGroup(Integer[] id);

    //精确查询
    public List<GoodsComment> selectGoodsComment(GoodsComment goodsComment);

    //模糊查询
    public List<GoodsComment> queryGoodsComment(GoodsComment goodsComment);

    public GoodsComment selectGoodsCommentById(Integer id);
}
