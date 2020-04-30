package com.collection.service;

import com.collection.eo.UserColl;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserCollService {
    //添加
    public Integer addUserColl(UserColl userColl);

    //修改
    public Integer updateUserColl(UserColl userColl);

    //删除
    public Integer deleteUserCollById(Integer id);

    //批量删除
    public Integer deleteUserCollByGroup(Integer[] id);

    //精确查询
    public List<UserColl> selectUserColl(UserColl userColl);

    //模糊查询
    public List<UserColl> queryUserColl(UserColl userColl);

    public UserColl selectUserCollById(Integer id);

    //精确查询
    public ServerResponse<PageInfo<UserColl>> selectUserCollForm(UserColl userColl, Page page);

    //模糊查询
    public ServerResponse<PageInfo<UserColl>> queryUserCollForm(UserColl userColl,Page page);
}
