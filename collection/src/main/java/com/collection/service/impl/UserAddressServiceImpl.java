package com.collection.service.impl;

import com.collection.dao.UserAddressDao;
import com.collection.eo.UserAddress;
import com.collection.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressDao userAddressDao;
    
    public Integer addUserAddress(UserAddress userAddress) {
        userAddress.setCreateTime(new Date());
        return userAddressDao.addUserAddress(userAddress);
    }

    public Integer updateUserAddress(UserAddress userAddress) {
        return userAddressDao.updateUserAddress(userAddress);
    }

    public Integer deleteUserAddressById(Integer id) {
        return userAddressDao.deleteUserAddressById(id);
    }

    public Integer deleteUserAddressByGroup(Integer[] id) {
        return userAddressDao.deleteUserAddressByGroup(id);
    }

    public List<UserAddress> selectUserAddress(UserAddress userAddress) {
        return userAddressDao.selectUserAddress(userAddress);
    }

    public List<UserAddress> queryUserAddress(UserAddress userAddress) {
        return userAddressDao.queryUserAddress(userAddress);
    }

    public UserAddress selectUserAddressById(Integer id) {
        return userAddressDao.selectUserAddressById(id);
    }

    public Boolean addressDefault(Integer id) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(id);
        userAddress.setIsDefault((byte)1);
        if (userAddressDao.updateUserAddress(userAddress) > 0) {
            return true;
        } else {
            return false;
        }

    }
}
