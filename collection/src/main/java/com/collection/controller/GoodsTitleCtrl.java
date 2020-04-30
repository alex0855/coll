package com.collection.controller;

import com.collection.eo.GoodsTitle;
import com.collection.service.GoodsTitleService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/goodsTitle")
public class GoodsTitleCtrl {

    @Autowired
    private GoodsTitleService goodsTitleService;

    @RequestMapping(value = "/add")
    public String add(GoodsTitle goodsTitle, Model model){
        Integer num = goodsTitleService.addGoodsTitle(goodsTitle);
        model.addAttribute("add", num);
        return "testeo";
    }

    @RequestMapping(value = "/update")
    public String update(GoodsTitle goodsTitle,Model model){
        Integer num = goodsTitleService.updateGoodsTitle(goodsTitle);
        model.addAttribute("update", num);
        return "testeo";
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id,Model model){
        Integer num = goodsTitleService.deleteGoodsTitleById(id);
        model.addAttribute("delete", num);
        return "testeo";
    }

    @RequestMapping(value = "/delete/group")
    public String deleteByGroup(Integer[] id,Model model){
        Integer num = goodsTitleService.deleteGoodsTitleByGroup(id);
        model.addAttribute("deleteByGroup", num);
        return "testeo";
    }

    @RequestMapping(value = "/select")
    public String select(GoodsTitle goodsTitle, Page<GoodsTitle> page, Model model) {
        List<GoodsTitle> num = goodsTitleService.selectGoodsTitle(goodsTitle);
        model.addAttribute("select", num);
        return "testeo";
    }

    @RequestMapping(value = "/query")
    public String query(GoodsTitle goodsTitle,Page<GoodsTitle> page, Model model) {
        List<GoodsTitle> num = goodsTitleService.queryGoodsTitle(goodsTitle);
        model.addAttribute("query", num);
        return "testeo";
    }

    @RequestMapping(value = "/seid")
    public String queryid(Integer id, Model model) {
        GoodsTitle num = goodsTitleService.selectGoodsTitleById(id);
        model.addAttribute("query", num);
        return "/back/testeo";
    }
}
