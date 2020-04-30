package com.collection.controller;

import com.collection.eo.Goods;
import com.collection.service.GoodsService;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/goods")
public class GoodsCtrl {

    @Autowired
    private GoodsService goodsService;

//    @RequestMapping(value = "/add")
//    public String add(Goods goods, Model model){
//        Integer num = goodsService.addGoods(goods);
//        model.addAttribute("add", num);
//        return "testeo";
//    }
//
//    @RequestMapping(value = "/update")
//    public String update(Goods goods,Model model){
//        Integer num = goodsService.updateGoods(goods);
//        model.addAttribute("update", num);
//        return "testeo";
//    }
//
//    @RequestMapping(value = "/delete")
//    public String delete(Integer id,Model model){
//        Integer num = goodsService.deleteGoodsById(id);
//        model.addAttribute("delete", num);
//        return "testeo";
//    }
//
//    @RequestMapping(value = "/delete/group")
//    public String deleteByGroup(Integer[] id,Model model){
//        Integer num = goodsService.deleteGoodsByGroup(id);
//        model.addAttribute("deleteByGroup", num);
//        return "testeo";
//    }

    @RequestMapping(value = "/select")
    public String select(Goods goods,Page<Goods> page, Model model) {
        ServerResponse response = goodsService.selectGoodsForm(goods,page);
        model.addAttribute("context", response);
        return "/forms/goodsForm";
    }

    @RequestMapping(value = "/query")
    public String query(Goods goods, Page<Goods> page, Model model) {
        ServerResponse response = goodsService.queryGoodsForm(goods,page);
        model.addAttribute("context", response);
        return "/forms/goodsForm";
    }

    @RequestMapping(value = "/list")
    public String goodsList(Model model) {
        ServerResponse response = goodsService.goodsList();
        model.addAttribute("context",response);
        return "/front/liebiao";
    }

    @RequestMapping(value = "/detail/{id}")
    public String goodsDetail(@PathVariable("id") Integer id, Model model) {
        ServerResponse response = goodsService.goodsDetail(id);
        model.addAttribute("context",response);
        return "/front/goodsDetail";
    }


}
