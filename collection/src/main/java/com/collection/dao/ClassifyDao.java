package com.collection.dao;

import com.collection.eo.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassifyDao {
    //添加
    public Integer addClassify(Classify classify);

    //修改
    public Integer updateClassify(Classify classify);

    //删除
    public Integer deleteClassifyById(Integer id);

    //精确查询
    public List<Classify> selectClassify(Classify classify);

    //模糊查询
    public List<Classify> queryClassify(Classify classify);

    public Classify selectClassifyById(@Param("id") Integer Id);
}
