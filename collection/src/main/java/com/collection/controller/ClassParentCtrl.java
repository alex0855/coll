package com.collection.controller;

import com.collection.eo.ClassParent;
import com.collection.service.ClassParentService;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/classParent")
public class ClassParentCtrl {

    @Autowired
    private ClassParentService classParentService;

    @RequestMapping(value = "/add")
    public String add(ClassParent classParent, Model model){
        Integer num = classParentService.addClassParent(classParent);
        if (num > 0) {
            return "redirect:/classParent/select";
        } else {
            return "/back/500";
        }
    }

//    @RequestMapping(value = "/addPage")
//    public String addPage(){
//        return "forms/addGoodsParam";
//    }

    @RequestMapping(value = "/update")
    public String update(ClassParent classParent,Model model){
        Integer num = classParentService.updateClassParent(classParent);
        model.addAttribute("update", num);
        return "testeo";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        Integer num = classParentService.deleteClassParentById(id);
        if (num > 0) {
            return "redirect:/classParent/select";
        } else {
            return "/back/500";
        }
    }


    @RequestMapping(value = "/select")
    public String select(ClassParent classParent, Page<ClassParent> page , Model model) {
        ServerResponse response = classParentService.selectClassParentForm(classParent, page);
        model.addAttribute("context",response);
        return "/forms/classParentForm";
    }

    @RequestMapping(value = "/query")
    public String query(ClassParent classParent,Page<ClassParent> page, Model model) {
        ServerResponse response = classParentService.queryClassParentForm(classParent, page);
        model.addAttribute("context",response);
        return "/forms/classParentForm";
    }

}
