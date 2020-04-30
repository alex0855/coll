package com.collection.controller;

import com.collection.eo.GoodsParamCust;
import com.collection.service.GoodsParamCustService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/goodsParamCust")
public class GoodsParamCustCtrl {

    @Autowired
    private GoodsParamCustService goodsParamCustService;

    @RequestMapping(value = "/add")
    public String add(GoodsParamCust goodsParamCust, Model model){
        Integer num = goodsParamCustService.addGoodsParamCust(goodsParamCust);
        model.addAttribute("add", num);
        return "testeo";
    }

    @RequestMapping(value = "/update")
    public String update(GoodsParamCust goodsParamCust,Model model){
        Integer num = goodsParamCustService.updateGoodsParamCust(goodsParamCust);
        model.addAttribute("update", num);
        return "testeo";
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id,Model model){
        Integer num = goodsParamCustService.deleteGoodsParamCustById(id);
        model.addAttribute("delete", num);
        return "testeo";
    }

    @RequestMapping(value = "/delete/group")
    public String deleteByGroup(Integer[] id,Model model){
        Integer num = goodsParamCustService.deleteGoodsParamCustByGroup(id);
        model.addAttribute("deleteByGroup", num);
        return "testeo";
    }

    @RequestMapping(value = "/select")
    public String select(GoodsParamCust goodsParamCust, Page<GoodsParamCust> page, Model model) {
        List<GoodsParamCust> num = goodsParamCustService.selectGoodsParamCust(goodsParamCust);
        model.addAttribute("select", num);
        return "testeo";
    }

    @RequestMapping(value = "/query")
    public String query(GoodsParamCust goodsParamCust,Page<GoodsParamCust> page, Model model) {
        List<GoodsParamCust> num = goodsParamCustService.queryGoodsParamCust(goodsParamCust);
        model.addAttribute("query", num);
        return "testeo";
    }
}

