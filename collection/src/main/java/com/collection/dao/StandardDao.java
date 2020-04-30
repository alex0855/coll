package com.collection.dao;

import com.collection.eo.Standard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StandardDao {
    //添加
    public Integer addStandard(Standard standard);

    //修改
    public Integer updateStandard(Standard standard);

    //删除
    public Integer deleteStandardById(Integer id);

    //批量删除
    public Integer deleteStandardByGroup(Integer[] id);

    //精确查询
    public List<Standard> selectStandard(Standard standard);

    //模糊查询
    public List<Standard> queryStandard(Standard standard);

    public Standard selectStandardById(Integer id);
}
