package com.collection.service.impl;

import com.collection.dao.ClassifyDao;
import com.collection.eo.Classify;
import com.collection.service.ClassifyService;
import com.collection.util.PageUtil;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyDao classifyDao;

    public Integer addClassify(Classify classify) {
        classify.setCreateTime(new Date());
        return classifyDao.addClassify(classify);
    }

    public Integer updateClassify(Classify classify) {
        return classifyDao.updateClassify(classify);
    }

    public Integer deleteClassifyById(Integer id) {
        return classifyDao.deleteClassifyById(id);
    }

    public List<Classify> selectClassify(Classify classify) {
        return classifyDao.selectClassify(classify);
    }

    public List<Classify> queryClassify(Classify classify) {
        return classifyDao.queryClassify(classify);
    }

    //id查询
    public Classify selectOne(Integer id) {
        Classify classify = new Classify();
        classify.setId(id);
        List<Classify> classifyList = classifyDao.selectClassify(classify);
        return classifyList.get(0);
    }

    //表格精确查询
    public ServerResponse<PageInfo<Classify>> selectClassifyForm(Classify classify, Page page) {
        PageUtil.initPage(page);
        List<Classify> classifyList = classifyDao.selectClassify(classify);
        PageInfo<Classify> pageInfo = new PageInfo<Classify>(classifyList);
        ServerResponse<PageInfo<Classify>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    //表格模糊查询
    public ServerResponse<PageInfo<Classify>> queryClassifyForm(Classify classify, Page page) {
        PageUtil.initPage(page);
        List<Classify> classifyList = classifyDao.queryClassify(classify);
        PageInfo<Classify> pageInfo = new PageInfo<Classify>(classifyList);
        ServerResponse<PageInfo<Classify>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    public Classify selectClassifyById(Integer id) {
        return classifyDao.selectClassifyById(id);
    }
}
