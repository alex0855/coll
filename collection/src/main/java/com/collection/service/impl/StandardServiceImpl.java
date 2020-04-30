package com.collection.service.impl;

import com.collection.dao.StandardDao;
import com.collection.eo.Standard;
import com.collection.service.StandardService;
import com.collection.util.PageUtil;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StandardServiceImpl implements StandardService {

    @Autowired
    private StandardDao standardDao;

    public Integer addStandard(Standard standard) {
        standard.setCreateTime(new Date());
        return standardDao.addStandard(standard);
    }

    public Integer updateStandard(Standard standard) {
        return standardDao.updateStandard(standard);
    }

    public Integer deleteStandardById(Integer id) {
        return standardDao.deleteStandardById(id);
    }

    public Integer deleteStandardByGroup(Integer[] id) {
        return standardDao.deleteStandardByGroup(id);
    }

    public List<Standard> selectStandard(Standard standard) {
        return standardDao.selectStandard(standard);
    }

    public List<Standard> queryStandard(Standard standard) {
        return standardDao.queryStandard(standard);
    }

    //表格精确查询
    public ServerResponse<PageInfo<Standard>> selectStandardForm(Standard standard, Page page) {
        PageUtil.initPage(page);
        List<Standard> standardList = selectStandard(standard);
        PageInfo<Standard> pageInfo = new PageInfo<Standard>(standardList);
        ServerResponse<PageInfo<Standard>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    //表格模糊查询
    public ServerResponse<PageInfo<Standard>> queryStandardForm(Standard standard, Page page) {
        PageUtil.initPage(page);
        List<Standard> standardList = queryStandard(standard);
        PageInfo<Standard> pageInfo = new PageInfo<Standard>(standardList);
        ServerResponse<PageInfo<Standard>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    public Standard selectStandardById(Integer id) {
        return standardDao.selectStandardById(id);
    }
}
