package com.collection.service;

import com.collection.eo.UserAddress;

import java.util.List;

public interface UserAddressService {
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

    public UserAddress selectUserAddressById(Integer id);

    //设置默认
    public Boolean addressDefault(Integer id);
}
