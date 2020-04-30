package com.collection.dao;

import com.collection.eo.UserToken;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserTokenDao {
    //添加
    public Integer addUserToken(UserToken userToken);

    //修改
    public Integer updateUserToken(UserToken userToken);

    //删除
    public Integer deleteUserTokenById(Integer id);

    //批量删除
    public Integer deleteUserTokenByGroup(Integer[] id);

    //精确查询
    public List<UserToken> selectUserToken(UserToken userToken);

    //模糊查询
    public List<UserToken> queryUserToken(UserToken userToken);

    //
    public UserToken selectByTicket(@Param("ticket") String ticket);
}
