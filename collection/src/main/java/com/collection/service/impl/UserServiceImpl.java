package com.collection.service.impl;

import com.collection.dao.UserDao;
import com.collection.dao.UserTokenDao;
import com.collection.eo.User;
import com.collection.eo.UserToken;
import com.collection.service.MailService;
import com.collection.service.UserService;
import com.collection.util.PageUtil;
import com.collection.util.ServerResponse;
import com.collection.util.UUIDUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 注入邮件接口
     */
    @Autowired
    private MailService mailService;

    @Autowired
    UserTokenDao userTokenDao;

    public Integer addUser(User user) {
        user.setCreateTime(new Date());
        return userDao.addUser(user);
    }

    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    public Integer deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    public Integer deleteUserByGroup(Integer[] id) {
        return userDao.deleteUserByGroup(id);
    }

    public List<User> selectUser(User user) {
        return userDao.selectUser(user);
    }

    public List<User> queryUser(User user) {
        return userDao.queryUser(user);
    }

    public ServerResponse<PageInfo<User>> selectUserForm(User user, Page page) {
        PageUtil.initPage(page);
        List<User> userList = userDao.selectUser(user);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        ServerResponse<PageInfo<User>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    public ServerResponse<PageInfo<User>> queryUserForm(User user, Page page) {
        PageUtil.initPage(page);
        List<User> userList = userDao.queryUser(user);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        ServerResponse<PageInfo<User>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    //用户注册，发送邮件
    public Boolean UserRegister(User user) {
        if(user==null){
            return false;
        }
        //用户激活状态设置0，生成激活码
        user.setStatus(0);
        String code = UUIDUtil.getUUID()+UUIDUtil.getUUID();
        user.setCode(code);
        addUser(user);
        //获取激活码
//        String code = user.getCode();
        System.out.println("code:"+code);
        //主题
        String subject = "来自收藏品交易系统网站的激活邮件";
        //user/checkCode?code=code(激活码)是我们点击邮件链接之后根据激活码查询用户，如果存在说明一致，将用户状态修改为“1”激活
        //上面的激活码发送到用户注册邮箱
        String context = "<a href=\"http://localhost:8080/user/checkCode?code="+code+"\">激活请点击:"+code+"</a>";
        //发送激活邮件
        mailService.sendHtmlMail (user.getEmail(),subject,context);
        return true;
    }

    public User checkCode(String code) {
        User user = new User();
        user.setCode(code);
        List<User> list = userDao.selectUser(user);
        if (list.size() <= 0) {
            return null;
        } else {
            user = list.get(0);
            return user;
        }
    }

    //用户登录
    public Map<String,Object> login(String username, String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isEmpty(username)){
            map.put("msg","用户名不能为空");
            return map;
        }

        if(StringUtils.isEmpty(password)){
            map.put("msg","密码不能为空");
            return map;
        }
        User user = findUserByAccount(username,password);
        if (user == null){
            map.put("msg","用户名不存在或密码错误");
            return map;
        }

        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);
        return map;
    }

    public String addLoginTicket(int userId){
        UserToken ticket = new UserToken();
        ticket.setUserId(userId);
        Date nowDate = new Date();
        nowDate.setTime(3600*24*100*200 + nowDate.getTime());
        ticket.setExpired(nowDate);
        ticket.setStatus((byte)0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("_",""));
        userTokenDao.addUserToken(ticket);
        return ticket.getTicket();

    }

    //根据用户名查询
    public User findUserByAccount(String username,String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        List<User> userList = selectUser(user);
        if (userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    public User selectUserById(Integer id) {
        User user = new User();
        user.setId(id);
        List<User> userList = selectUser(user);
        if (userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    public Boolean forgetPassword(String username,String email) {
        User user = userDao.selectByNameAndEmail(username,email);
        if (user==null) {
            return false;
        }
        String newPass = "";
        for (int i = 0; i < 6; i++) {
            int r = (int)(Math.random()*10);
            newPass = newPass + r;
        }
        //对用户重置密码
        user.setPassword(newPass);
        updateUser(user);
        String subject = "密码重置";
        String context = "亲爱的用户，你密码重置为  "+newPass;
        mailService.sendHtmlMail(email,subject,context);
        return true;
    }
}
