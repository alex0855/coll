package com.collection.dao;

import com.collection.eo.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAddressDao {

    //添加
    public Integer addUserAddress(UserAddress userAddress);

    //修改
    public Integer updateUserAddress(UserAddress userAddress);

    //删除
    public Integer deleteUserAddressById(Integer id);

    //批量删除
    public Integer deleteUserAddressByGroup(Integer[] id);

    //精确查询
    public List<UserAddress> selectUserAddress(UserAddress userAddress);

    //模糊查询
    public List<UserAddress> queryUserAddress(UserAddress userAddress);

    public UserAddress selectUserAddressById(@Param("id") Integer id);
}
