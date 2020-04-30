package com.collection.controller;

import com.collection.eo.ClassParent;
import com.collection.eo.Classify;
import com.collection.service.ClassParentService;
import com.collection.service.ClassifyService;
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
@RequestMapping(value = "/classify")
public class ClassifyCtrl {
    
    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private ClassParentService classParentService;

    @RequestMapping(value = "/add")
    public String add(Classify classify, Model model){
        Integer num = classifyService.addClassify(classify);
        ClassParent classParent = classParentService.selectClassifyParentById(classify.getParentId());
        if (num > 0) {
            String cid = String.valueOf(classParent.getId());
            String url = "redirect:/classify/select/"+cid;
            return url;
        } else {
            return "/back/500";
        }
    }

    @RequestMapping(value = "/update")
    public String update(Classify classify,Model model){
        Integer num = classifyService.updateClassify(classify);
        if (num > 0) {
            return "redirect:/classify/select";
        } else {
            return "/back/500";
        }
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        Classify classify = classifyService.selectClassifyById(id);
        ClassParent classParent = null;
        if(classify!=null) {
            classParent = classParentService.selectClassifyParentById(classify.getParentId());
        }
        Integer num = classifyService.deleteClassifyById(id);
        if (num > 0) {
            String cid = String.valueOf(classParent.getId());
            String url = "redirect:/classify/select/"+cid;
            return url;
        } else {
            return "/back/500";
        }
    }


    @RequestMapping(value = "/select/{id}")
    public String select(@PathVariable("id") Integer parentId, Page<Classify> page ,Model model) {
        Classify classify = new Classify();
        classify.setParentId(parentId);
        ClassParent classParent = classParentService.selectClassifyParentById(parentId);
        ServerResponse response = classifyService.selectClassifyForm(classify, page);
        model.addAttribute("context",response);
        model.addAttribute("parentId",parentId);
        model.addAttribute("parent",classParent);
        return "/forms/classifyForm";
    }

    @RequestMapping(value = "/select")
    public String select(Classify classify,Page<Classify> page ,Model model) {
        ServerResponse response = classifyService.selectClassifyForm(classify, page);
        ClassParent classParent = classParentService.selectClassifyParentById(classify.getParentId());
        model.addAttribute("context",response);
        model.addAttribute("parentId",classify.getParentId());
        model.addAttribute("parent",classParent);
        return "/forms/classifyForm";
    }

    @RequestMapping(value = "/query")
    public String query(Classify classify,Page<Classify> page, Model model) {
        ServerResponse response = classifyService.queryClassifyForm(classify,page);
        model.addAttribute("context",response);
        return "/forms/classifyForm";
    }

    @ResponseBody
    @RequestMapping(value = "/classParentList")
    public List<ClassParent> selectClassParentList(){
        ClassParent classParent = new ClassParent();
        List<ClassParent> classParentList = classParentService.selectClassParent(classParent);
        return classParentList;
    }


    @ResponseBody
    @RequestMapping(value = "/classifyListByParentId")
    public List<Classify> selectClassifyListByParentId(Integer classParentId){
        Classify classify = new Classify();
        classify.setParentId(classParentId);
        List<Classify> classifyList = classifyService.selectClassify(classify);
        return classifyList;
    }
}
