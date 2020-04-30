package com.collection.controller;

import com.collection.eo.Goods;
import com.collection.eo.Standard;
import com.collection.service.StandardService;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/standard")
@Controller
public class StandardCtrl {

    @Autowired
    private StandardService standardService;

    @RequestMapping(value = "/add")
    public String add(Standard standard) {
        if(standard!=null&&standard.getGoods().getId()!=null) {
            Integer num = standardService.addStandard(standard);
            if (num > 0) {
                String id = String.valueOf(standard.getGoods().getId());
                String url = "redirect:/standard/select/"+id;
                return url;
            } else {
                return "500";
            }
        }else {
            return "500";
        }
    }


    @RequestMapping(value = "/update")
    public String update(Standard standard, Model model){
        Integer num = standardService.updateStandard(standard);
        if (num > 0) {
            return "redirect:/standard/select";
        } else {
            return "500";
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        Integer num = standardService.deleteStandardById(id);
        if (num > 0) {
            return "redirect:/standard/select";
        } else {
            return "500";
        }
    }


    @RequestMapping(value = "/select/{id}")
    public String select(@PathVariable("id") Integer id, Page<Standard> page , Model model) {
        ServerResponse response = null;
        Standard standard = new Standard();
        Goods goods = new Goods();
        goods.setId(id);
        standard.setGoods(goods);
        model.addAttribute("goods",goods);
        if(standard.getGoods().getId()!=null) {
            response = standardService.selectStandardForm(standard, page);
        }else {
            response = ServerResponse.createBySuccess();
        }
        model.addAttribute("context",response);
        return "/forms/standardForm";
    }

    @RequestMapping(value = "/query")
    public String query(Standard standard,Page<Standard> page, Model model) {
        ServerResponse response = null;
        if(standard.getGoods().getId()!=null) {
            response = standardService.queryStandardForm(standard, page);
        }else {
            response = ServerResponse.createBySuccess();
        }
        model.addAttribute("context",response);
        return "/forms/standardForm";
    }
}
