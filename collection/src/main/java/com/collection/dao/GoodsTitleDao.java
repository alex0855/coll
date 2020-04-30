package com.collection.dao;

import com.collection.eo.GoodsTitle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsTitleDao {
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
    public List<GoodsTitle> selectListByGoodsId(@Param("goodsId") Integer goodsId);

    public GoodsTitle selectByGoodsId(@Param("goodsId") Integer goodsId);

    public GoodsTitle selectGoodsTitleById(@Param("id") Integer Id);
}
