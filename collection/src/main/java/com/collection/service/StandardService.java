package com.collection.service;

import com.collection.eo.Standard;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StandardService {
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

    //表格精确查询
    public ServerResponse<PageInfo<Standard>> selectStandardForm(Standard standard, Page page);

    //表格模糊查询
    public ServerResponse<PageInfo<Standard>> queryStandardForm(Standard standard, Page page);

    public Standard selectStandardById(Integer id);
}
