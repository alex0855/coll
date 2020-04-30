package com.collection.dao;

import com.collection.eo.GoodsQues;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsQuesDao {
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

    public GoodsQues selectGoodsQuesById(@Param("id") Integer id);
}
