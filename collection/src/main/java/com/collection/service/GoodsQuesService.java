package com.collection.service;

import com.collection.eo.GoodsQues;

import java.util.List;

public interface GoodsQuesService {
    //添加
    public Integer addGoodsQues(GoodsQues goodsQues);

    //修改
    public Integer updateGoodsQues(GoodsQues goodsQues);

    //删除
    public Integer deleteGoodsQuesById(Integer id);

    //批量删除
    public Integer deleteGoodsQuesByGroup(Integer[] id);

    //精确查询
    public List<GoodsQues> selectGoodsQues(GoodsQues goodsQues);

    //模糊查询
    public List<GoodsQues> queryGoodsQues(GoodsQues goodsQues);

    public GoodsQues selectGoodsQuesById(Integer id);
}
