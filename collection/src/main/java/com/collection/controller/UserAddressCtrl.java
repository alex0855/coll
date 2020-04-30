package com.collection.controller;

import com.collection.eo.User;
import com.collection.eo.UserAddress;
import com.collection.eo.UserColl;
import com.collection.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/userAddress")
public class UserAddressCtrl {
    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping(value = "/add")
    public String add(UserAddress userAddress, HttpServletRequest request, Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            userAddress.setUser(user);
            Integer num = userAddressService.addUserAddress(userAddress);
//            model.addAttribute("add",num);
            return "redirect:/userAddress/self/select";
        }
    }

    @RequestMapping(value = "/self/select")
    public String select(HttpServletRequest request,Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            UserAddress userAddress = new UserAddress();
            userAddress.setUser(user);
            List<UserAddress> userAddressList = userAddressService.selectUserAddress(userAddress);
            model.addAttribute("address",userAddressList);
            return "/front/selfAddress";
        }
    }

    @RequestMapping(value = "/self/delect/{id}")
    public String select(@PathVariable("id") Integer id, HttpServletRequest request, Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
           userAddressService.deleteUserAddressById(id);
           return "redirect:/userAddress/self/select";
        }
    }

    @RequestMapping(value = "/self/default/{id}")
    public String defalut(@PathVariable("id") Integer id, HttpServletRequest request, Model model) {
        User user = (User)request.getAttribute("user");
        if (user == null) {
            return "redirect:/user/loginPage";
        } else {
            userAddressService.addressDefault(id);
            return "redirect:/userAddress/self/select";
        }
    }
}
