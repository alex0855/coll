package com.collection.dao;

import com.collection.eo.UserColl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCollDao {
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

    public UserColl selectUserCollById(@Param("id") Integer id);
}
