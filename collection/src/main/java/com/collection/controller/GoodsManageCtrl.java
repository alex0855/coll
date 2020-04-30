package com.collection.controller;

import com.collection.service.GoodsService;
import com.collection.vo.AddGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoodsManageCtrl {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/addGoodsManagePage")
    public String addGoodsPage() {
        return "forms/addGoodsManageForm";
    }

    @RequestMapping(value = "/addGoodsManage",method = RequestMethod.POST)
    public String addGoods(AddGoodsVo addGoodsVo){
        if (goodsService.addGoodsManage(addGoodsVo)) {
            return "redirect:/goods/select";
        } else {
            return "/back/500";
        }
    }

    @RequestMapping(value = "/showGoodsManage/{goodsId}")
    public String showGoods(@PathVariable("goodsId") Integer goodsId, Model model){
        AddGoodsVo addGoodsVo = goodsService.showGoodsManage(goodsId);
        model.addAttribute("context",addGoodsVo);
        return "/back/showGoodsManage";
    }

    @RequestMapping(value = "/updateGoodsManage")
    public String updateGoods(AddGoodsVo addGoodsVo, Model model){
        if (goodsService.updateGoodsManage(addGoodsVo)) {
            return "redirect:/goods/select";
        } else {
            return "/back/500";
        }
    }

}
