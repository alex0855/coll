package com.collection.service;

import com.collection.eo.ClassParent;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ClassParentService {
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

    //表格精确查询
    public ServerResponse<PageInfo<ClassParent>> selectClassParentForm(ClassParent classParent, Page page);

    //表格模糊查询
    public ServerResponse<PageInfo<ClassParent>> queryClassParentForm(ClassParent classParent, Page page);

    public ClassParent selectClassifyParentById(Integer id);
}
