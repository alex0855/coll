package com.collection.service;

import com.collection.eo.GoodsParamCust;
import com.github.pagehelper.Page;

import java.util.List;

public interface GoodsParamCustService {
    //添加
    public Integer addGoodsParamCust(GoodsParamCust goodsParamCust);

    //修改
    public Integer updateGoodsParamCust(GoodsParamCust goodsParamCust);

    //删除
    public Integer deleteGoodsParamCustById(Integer id);

    //批量删除
    public Integer deleteGoodsParamCustByGroup(Integer[] id);

    //精确查询
    public List<GoodsParamCust> selectGoodsParamCust(GoodsParamCust goodsParamCust);

    //模糊查询
    public List<GoodsParamCust> queryGoodsParamCust(GoodsParamCust goodsParamCust);

    public List<GoodsParamCust> selectGoodsParamCustByGoodsId(Integer goodsId);
}
