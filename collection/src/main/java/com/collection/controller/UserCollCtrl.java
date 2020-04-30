package com.collection.controller;

import com.collection.eo.Goods;
import com.collection.eo.User;
import com.collection.eo.UserColl;
import com.collection.service.UserCollService;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/userColl")
public class UserCollCtrl {

    @Autowired
    private UserCollService userCollService;

    @RequestMapping(value = "/add/{goodsId}")
    public String add(@PathVariable("goodsId") Integer id,HttpServletRequest request) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            UserColl userColl = new UserColl();
            userColl.setUser(user);
            Goods goods = new Goods();
            goods.setId(id);
            userColl.setGoods(goods);

            String gid = String.valueOf(id);
            String url = "redirect:/goods/detail/"+gid;

            List<UserColl> userCollList = userCollService.selectUserColl(userColl);
            if (userCollList.size()>0) {
                return url;
            }
            userCollService.addUserColl(userColl);
            return url;
        }
    }

    @RequestMapping(value = "/self/select")
    public String selfSelect(HttpServletRequest request, Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            UserColl userColl = new UserColl();
            userColl.setUser(user);
            List<UserColl> userCollList = userCollService.selectUserColl(userColl);
            model.addAttribute("usercoll",userCollList);
            return "/front/selfColl";
        }
    }

    @RequestMapping(value = "/self/delete/{id}")
    public String selfDelete(@PathVariable("id") Integer id, HttpServletRequest request, Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            if (userCollService.deleteUserCollById(id) > 0) {
                return "redirect:/userColl/self/select";
            } else {
                return "redirect:/userColl/self/select";
            }
        }
    }

    @RequestMapping(value = "/select")
    public String selfSelect(UserColl userColl,Page<UserColl> page,Model model) {
        ServerResponse response = userCollService.selectUserCollForm(userColl,page);
        model.addAttribute("context",response);
        return "/forms/userCollForm";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model) {
            if (userCollService.deleteUserCollById(id) > 0) {
                return "redirect:/userColl/select";
            } else {
                return "redirect:/userColl/select";
            }
        }
}
