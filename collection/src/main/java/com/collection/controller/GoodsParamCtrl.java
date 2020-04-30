package com.collection.controller;

import com.collection.eo.GoodsParam;
import com.collection.service.GoodsParamService;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/goodsParam")
public class GoodsParamCtrl {

    @Autowired
    private GoodsParamService goodsParamService;

    @RequestMapping(value = "/add")
    public String add(GoodsParam goodsParam){
        Integer num = goodsParamService.addGoodsParam(goodsParam);
        if (num > 0) {
            return "redirect:/goodsParam/select";
        } else {
            return "500";
        }
    }

    @RequestMapping(value = "/addPage")
    public String addPage(){
        return "forms/addGoodsParam";
    }

    @RequestMapping(value = "/update")
    public String update(GoodsParam goodsParam,Model model){
        Integer num = goodsParamService.updateGoodsParam(goodsParam);
        if (num > 0) {
            return "redirect:/goodsParam/select";
        } else {
            return "500";
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        Integer num = goodsParamService.deleteGoodsParamById(id);
        if (num > 0) {
            return "redirect:/goodsParam/select";
        } else {
            return "500";
        }
    }

    @RequestMapping(value = "/delete/group")
    public String deleteByGroup(Integer[] id,Model model){
        Integer num = goodsParamService.deleteGoodsParamByGroup(id);
        model.addAttribute("deleteByGroup", num);
        return "testeo";
    }

    @RequestMapping(value = "/select")
    public String select(GoodsParam goodsParam,Page<GoodsParam> page, Model model) {
        ServerResponse response = goodsParamService.selectGoodsParamForm(goodsParam, page);
        model.addAttribute("context",response);
        return "/forms/goodsParamForm";
    }

    @RequestMapping(value = "/query")
    public String query(GoodsParam goodsParam,Page<GoodsParam> page,Model model) {
        ServerResponse response = goodsParamService.queryGoodsParamForm(goodsParam, page);
        model.addAttribute("context",response);
        return "/forms/goodsParamForm";
    }

    @ResponseBody
    @RequestMapping(value = "/selectGoodsParamList")
    public List<GoodsParam> selectParmList() {
        GoodsParam goodsParam = new GoodsParam();
        List<GoodsParam> goodsParamList = goodsParamService.selectGoodsParam(goodsParam);
        return goodsParamList;
    }
}
