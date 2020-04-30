package com.collection.dao;

import com.collection.eo.GoodsImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsImageDao {
    //添加
    public Integer addGoodsImage(GoodsImage goodsImage);

    //修改
    public Integer updateGoodsImage(GoodsImage goodsImage);

    //删除
    public Integer deleteGoodsImageById(Integer id);

    //批量删除
    public Integer deleteGoodsImageByGroup(Integer[] id);

    //查询
    public List<GoodsImage> selectGoodsImage(GoodsImage goodsImage);

    //模糊查询
    public List<GoodsImage> queryGoodsImage(GoodsImage goodsImage);

    //根据goodsId查询
    public List<GoodsImage> selectListByGoodsId(@Param("goodsId") Integer goodsId);

    public GoodsImage selectByGoodsId(@Param("goodsId") Integer goodsId);

    public GoodsImage selectGoodsImageById(@Param("id") Integer Id);
}
