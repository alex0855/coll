package com.collection.controller;

import com.collection.eo.Ad;
import com.collection.eo.User;
import com.collection.service.AdService;
import com.collection.service.UserService;
import com.collection.service.impl.TestService;
import com.collection.vo.AdVo;
import com.collection.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class IndexCtrl {

    @Autowired
    private TestService testService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdService adService;

    @RequestMapping(value = "/hello")
    public String hello(){
        return "/back/success";
    }

    @RequestMapping(value = "/find")
    public String find(){
       return "/back/500";
    }


    @RequestMapping(value = "/tables")
    public String tables() {
        return "/forms/tables";
    }


    @RequestMapping(value = "/index")
    public String front() {
        return "/front/index";
    }


    @RequestMapping(value = "/indexm")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/ad/select")
    public String adSelect(Ad ad, Model model) {
        List<Ad> adList = adService.selectAd(ad);
        model.addAttribute("ad",adList);
        return "/forms/adForm";
    }

    @RequestMapping(value = "/ad/update")
    public String adUpdate(AdVo advo) {
        Ad ad = null;
        if (advo != null) {
            ad=advo.getAd();
            if (!advo.getFile().getOriginalFilename().equals("")){
                ad.setFile(advo.getFile());
            }
        }
        if (adService.updateAd(ad) > 0) {
            return "redirect:/ad/select";
        } else {
            return "redirect:/ad/select";
        }
    }
}
