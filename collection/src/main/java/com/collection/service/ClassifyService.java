package com.collection.service;

import com.collection.eo.Classify;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ClassifyService {
    //添加
    public Integer addClassify(Classify classify);

    //修改
    public Integer updateClassify(Classify classify);

    //删除
    public Integer deleteClassifyById(Integer id);

    //查询
    public List<Classify> selectClassify(Classify classify);

    //模糊查询
    public List<Classify> queryClassify(Classify classify);

    //表格精确查询
    public ServerResponse<PageInfo<Classify>> selectClassifyForm(Classify classify, Page page);

    //表格模糊查询
    public ServerResponse<PageInfo<Classify>> queryClassifyForm(Classify classify, Page page);

    public Classify selectClassifyById(Integer id);
}
