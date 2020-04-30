package com.collection.dao;

import com.collection.eo.StandardClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StandardClassDao {
    //添加
    public Integer addStandardClass(StandardClass standardClass);

    //修改
    public Integer updateStandardClass(StandardClass standardClass);

    //删除
    public Integer deleteStandardClassById(Integer id);

    //批量删除
    public Integer deleteStandardClassByGroup(Integer[] id);

    //精确查询
    public List<StandardClass> selectStandardClass(StandardClass standardClass);

    //模糊查询
    public List<StandardClass> queryStandardClass(StandardClass standardClass);
}
