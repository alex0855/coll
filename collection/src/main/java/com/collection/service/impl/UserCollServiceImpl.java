package com.collection.service.impl;

import com.collection.dao.UserCollDao;
import com.collection.eo.UserColl;
import com.collection.service.UserCollService;
import com.collection.util.PageUtil;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserCollServiceImpl implements UserCollService {
    @Autowired
    private UserCollDao userCollDao;

    public Integer addUserColl(UserColl userColl) {
        userColl.setCreateTime(new Date());
        return userCollDao.addUserColl(userColl);
    }

    public Integer updateUserColl(UserColl userColl) {
        return userCollDao.updateUserColl(userColl);
    }

    public Integer deleteUserCollById(Integer id) {
        return userCollDao.deleteUserCollById(id);
    }

    public Integer deleteUserCollByGroup(Integer[] id) {
        return userCollDao.deleteUserCollByGroup(id);
    }

    public List<UserColl> selectUserColl(UserColl userColl) {
        return userCollDao.selectUserColl(userColl);
    }

    public List<UserColl> queryUserColl(UserColl userColl) {
        return userCollDao.queryUserColl(userColl);
    }

    public UserColl selectUserCollById(Integer id) {
        return userCollDao.selectUserCollById(id);
    }

    public ServerResponse<PageInfo<UserColl>> selectUserCollForm(UserColl userColl, Page page) {
        PageUtil.initPage(page);
        List<UserColl> userCollList = userCollDao.selectUserColl(userColl);
        PageInfo<UserColl> pageInfo = new PageInfo<UserColl>(userCollList);
        ServerResponse<PageInfo<UserColl>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    public ServerResponse<PageInfo<UserColl>> queryUserCollForm(UserColl userColl, Page page) {
        PageUtil.initPage(page);
        List<UserColl> userCollList = userCollDao.queryUserColl(userColl);
        PageInfo<UserColl> pageInfo = new PageInfo<UserColl>(userCollList);
        ServerResponse<PageInfo<UserColl>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }
}
