package com.collection.dao;

import com.collection.eo.GoodsParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsParamDao {

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

    public GoodsParam selectGoodsParamById(Integer id);
}
