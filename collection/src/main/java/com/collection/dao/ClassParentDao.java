package com.collection.dao;

import com.collection.eo.ClassParent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassParentDao {
    //添加
    public Integer addClassParent(ClassParent classParent);

    //修改
    public Integer updateClassParent(ClassParent classParent);

    //删除
    public Integer deleteClassParentById(Integer id);

    //精确查询
    public List<ClassParent> selectClassParent(ClassParent classParent);

    //模糊查询
    public List<ClassParent> queryClassParent(ClassParent classParent);

    public ClassParent selectClassParentById(@Param("id") Integer Id);
}
