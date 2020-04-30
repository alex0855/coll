package com.collection.dao;

import com.collection.eo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    //添加
    public Integer addUser(User user);

    //修改
    public Integer updateUser(User user);

    //删除
    public Integer deleteUserById(Integer id);

    //批量删除
    public Integer deleteUserByGroup(Integer[] id);

    //精确查询
    public List<User> selectUser(User user);

    //模糊查询
    public List<User> queryUser(User user);

    public User selectUserById(Integer id);

    //根据用户名和email查询用户
    public  User selectByNameAndEmail(@Param("username")String username,@Param("email")String email);
}
