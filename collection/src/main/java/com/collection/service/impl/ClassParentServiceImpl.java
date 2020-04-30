package com.collection.service.impl;

import com.collection.dao.ClassParentDao;
import com.collection.eo.ClassParent;
import com.collection.service.ClassParentService;
import com.collection.util.PageUtil;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClassParentServiceImpl implements ClassParentService {
    
    @Autowired
    private ClassParentDao classParentDao;
    
    public Integer addClassParent(ClassParent classParent) {
        classParent.setCreateTime(new Date());
        return classParentDao.addClassParent(classParent);
    }

    public Integer updateClassParent(ClassParent classParent) {
        return classParentDao.updateClassParent(classParent);
    }

    public Integer deleteClassParentById(Integer id) {
        return classParentDao.deleteClassParentById(id);
    }

    public List<ClassParent> selectClassParent(ClassParent classParent) {
        return classParentDao.selectClassParent(classParent);
    }

    public List<ClassParent> queryClassParent(ClassParent classParent) {
        return classParentDao.queryClassParent(classParent);
    }

    //id查询
    public ClassParent selectOne(Integer id) {
        ClassParent classParent = new ClassParent();
        classParent.setId(id);
        List<ClassParent> classParentList = classParentDao.selectClassParent(classParent);
        return classParentList.get(0);
    }

    //表格精确查询
    public ServerResponse<PageInfo<ClassParent>> selectClassParentForm(ClassParent classParent, Page page) {
        PageUtil.initPage(page);
        List<ClassParent> classParentList = classParentDao.selectClassParent(classParent);
        PageInfo<ClassParent> pageInfo = new PageInfo<ClassParent>(classParentList);
        ServerResponse<PageInfo<ClassParent>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    //表格模糊查询
    public ServerResponse<PageInfo<ClassParent>> queryClassParentForm(ClassParent classParent, Page page) {
        PageUtil.initPage(page);
        List<ClassParent> classParentList = classParentDao.queryClassParent(classParent);
        PageInfo<ClassParent> pageInfo = new PageInfo<ClassParent>(classParentList);
        ServerResponse<PageInfo<ClassParent>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    public ClassParent selectClassifyParentById(Integer id) {
        return classParentDao.selectClassParentById(id);
    }
}
