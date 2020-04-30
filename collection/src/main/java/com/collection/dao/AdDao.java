package com.collection.dao;

import com.collection.eo.Ad;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdDao {
    //添加
    public Integer addAd(Ad ad);

    //修改
    public Integer updateAd(Ad ad);

    //删除
    public Integer deleteAdById(Integer id);

    //批量删除
    public Integer deleteAdByGroup(Integer[] id);

    //精确查询
    public List<Ad> selectAd(Ad ad);

    //模糊查询
    public List<Ad> queryAd(Ad ad);

    public Ad selectAdById(@Param("id") Integer id);
}
