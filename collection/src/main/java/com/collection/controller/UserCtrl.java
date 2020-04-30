package com.collection.controller;

import com.collection.eo.User;
import com.collection.service.UserService;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.LockedAccountException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserCtrl {

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/add")
//    public String add(User user, Model model){
//        Integer num = userService.addUser(user);
//        model.addAttribute("add", num);
//        return "testeo";
//    }

    @RequestMapping(value = "/update")
    public String update(User user,Model model){
        Integer num = userService.updateUser(user);
        if (num > 0) {
            return "redirect:/user/select";
        } else {
            return "/back/500";
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        Integer num = userService.deleteUserById(id);
        if (num > 0) {
            return "redirect:/user/select";
        } else {
            return "/back/500";
        }
    }

    @RequestMapping(value = "/select")
    public String select(User user, Page<User> page, Model model) {
        ServerResponse response = userService.selectUserForm(user, page);
        model.addAttribute("context", response);
        return "/forms/userForm";
    }


    @RequestMapping(value = "/query")
    public String query(User user,Page<User> page,Model model) {
        ServerResponse response = userService.queryUserForm(user, page);
        model.addAttribute("context", response);
        return "/forms/userForm";
    }

    @RequestMapping(value = "/register")
    public String register(User user) {
        if (userService.UserRegister(user)) {
            return "/front/login";
        }else
            return "/back/505";
    }

    @RequestMapping(value = "/checkCode")
    public String register(String code) {
        User user = userService.checkCode(code);
        if (user!=null) {
            user.setStatus(1);
            userService.updateUser(user);
            return "/back/success";
        }else
            return "/back/505";
    }

    @RequestMapping(value = "/registerPage")
    public String registerPage() {
        return "/front/register";
    }

    @RequestMapping(value = "/loginPage")
    public String loginPage() {
        return "/front/login";
    }

    @RequestMapping(value = "/loginn")
    public String login(User user,HttpServletResponse response) {
        Map<String,Object> map = userService.login(user.getUsername(), user.getPassword());
        if (map.containsKey("ticket")) {
            Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
            cookie.setPath("/");
            response.addCookie(cookie);
            return "forward:/index";
        } else {
            return "/front/login";
        }
    }

//    @RequestMapping(value = "/login")
//    public String loginn(User user,HttpServletResponse response) {
//        if (user == null) {
//            return "/front/login";
//        }
//        String username = user.getUsername();
//        String password = user.getPassword();
//        Subject currentUser = SecurityUtils.getSubject();
//        try {
//            currentUser.login(new UsernamePasswordToken(username, password));
//        } catch (UnknownAccountException uae) {
//            return "/front/login";
//        } catch (LockedAccountException lae) {
//            return "/front/login";
//
//        } catch (AuthenticationException ae) {
//            return "/front/login";
//        }
//        return "forward:/index";
//    }


    @RequestMapping(value = "/self/info")
    public String selectUser(HttpServletRequest request,Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            model.addAttribute("context",user);
        }
        return "/front/selfInfo";
    }

    @RequestMapping(value = "/self/info/change")
    public String selfChange(HttpServletRequest request,User chnageUser) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            chnageUser.setId(user.getId());
            userService.updateUser(chnageUser);
            return "redirect:/user/self/info";
        }
    }

    @RequestMapping(value = "/change/passwordPage")
    public String passChange(HttpServletRequest request) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        }
        return "/front/password";
    }

    @RequestMapping(value = "/change/password")
    public String passChange(HttpServletRequest request,String oldPass,String newPass,Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        }else {
            if (user.getPassword().equals(oldPass)) {
                user.setPassword(newPass);
                userService.updateUser(user);
                model.addAttribute("flag","true");
                return "/front/password";
            } else {
                model.addAttribute("flag","false");
                return "/front/password";
            }
        }
    }

    @RequestMapping(value = "/forget/passwordPage")
    public String forgetPassPage() {
        return "/front/forgetPassword";
    }

    @RequestMapping(value = "/forget/password")
    public String forgetPass(String username,String email) {
        if (email==null||email.equals("")) {
            return "/front/forgetPassword";
        } else {
            if (userService.forgetPassword(username, email) == false) {
                return "/front/forgetPassword";
            } else {
                return "redirect:/user/loginPage";
            }
        }
    }
}
