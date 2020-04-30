package com.collection.service.impl;

import com.collection.dao.StandardClassDao;
import com.collection.eo.StandardClass;
import com.collection.service.StandardClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StandardClassServiceImpl implements StandardClassService {
    @Autowired
    private StandardClassDao standardClassDao;

    public Integer addStandardClass(StandardClass standardClass) {
        standardClass.setCreateTime(new Date());
        return standardClassDao.addStandardClass(standardClass);
    }

    public Integer updateStandardClass(StandardClass standardClass) {
        return standardClassDao.updateStandardClass(standardClass);
    }

    public Integer deleteStandardClassById(Integer id) {
        return standardClassDao.deleteStandardClassById(id);
    }

    public Integer deleteStandardClassByGroup(Integer[] id) {
        return standardClassDao.deleteStandardClassByGroup(id);
    }

    public List<StandardClass> selectStandardClass(StandardClass standardClass) {
        return standardClassDao.selectStandardClass(standardClass);
    }

    public List<StandardClass> queryStandardClass(StandardClass standardClass) {
        return standardClassDao.queryStandardClass(standardClass);
    }
}
