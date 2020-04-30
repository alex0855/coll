package com.collection.service;

import com.collection.eo.GoodsTitle;
import com.github.pagehelper.Page;

import java.util.List;

public interface GoodsTitleService {
    //添加
    public Integer addGoodsTitle(GoodsTitle goodsTitle);

    //修改
    public Integer updateGoodsTitle(GoodsTitle goodsTitle);

    //删除
    public Integer deleteGoodsTitleById(Integer id);

    //批量删除
    public Integer deleteGoodsTitleByGroup(Integer[] id);

    //精确查询
    public List<GoodsTitle> selectGoodsTitle(GoodsTitle goodsTitle);

    //模糊查询
    public List<GoodsTitle> queryGoodsTitle(GoodsTitle goodsTitle);

    //根据goodsId查询
    public List<GoodsTitle> selectListGoodsTitle(Integer goodsId);

    public GoodsTitle selectGoodsTitleByGoodsId(Integer goodsId);

    public GoodsTitle selectGoodsTitleById(Integer id);
}
