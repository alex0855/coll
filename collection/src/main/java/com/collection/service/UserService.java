package com.collection.service;

import com.collection.eo.User;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface UserService {

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

    //精确查询
    public ServerResponse<PageInfo<User>> selectUserForm(User user, Page page);

    //模糊查询
    public ServerResponse<PageInfo<User>> queryUserForm(User user,Page page);

    //用户注册，发送邮件
    public Boolean UserRegister(User user);

    //用户激活账号
    public User checkCode(String code);

    //用户登录
    public Map<String,Object> login(String username, String password);

    //根据用户名查询
    public User findUserByAccount(String username,String password);

    //根据id查询
    public User selectUserById(Integer id);

    //忘记密码
    public Boolean forgetPassword(String username,String email);
}
