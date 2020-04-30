package com.collection.service;

import com.collection.eo.GoodsParam;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsParamService {
    //添加
    public Integer addGoodsParam(GoodsParam goodsParam);

    //修改
    public Integer updateGoodsParam(GoodsParam goodsParam);

    //删除
    public Integer deleteGoodsParamById(Integer id);

    //批量删除
    public Integer deleteGoodsParamByGroup(Integer[] id);

    //精确查询
    public List<GoodsParam> selectGoodsParam(GoodsParam goodsParam);

    //模糊查询
    public List<GoodsParam> queryGoodsParam(GoodsParam goodsParam);

    //表格精确查询
    public ServerResponse<PageInfo<GoodsParam>> selectGoodsParamForm(GoodsParam goodsParam, Page page);

    //表格模糊查询
    public ServerResponse<PageInfo<GoodsParam>> queryGoodsParamForm(GoodsParam goodsParam, Page page);

    public GoodsParam selectGoodsParamById(Integer id);
}
