package com.collection.dao;

import com.collection.eo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {

    //添加
    public Integer addGoods(Goods goods);

    //修改
    public Integer updateGoods(Goods goods);

    //删除
    public Integer deleteGoodsById(Integer id);

    //批量删除
    public Integer deleteGoodsByGroup(Integer[] id);

    //查询
    public List<Goods> selectGoods(Goods goods);

    //模糊查询
    public List<Goods> queryGoods(Goods goods);

    public Goods selectGoodsById(@Param("id") Integer id);
}
