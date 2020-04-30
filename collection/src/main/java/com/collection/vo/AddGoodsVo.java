package com.collection.vo;

import com.collection.eo.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class AddGoodsVo {

    private Goods goods;

    private GoodsTitle goodsTitle;

    private Classify classify;

    private ClassParent classParent;

    private List<GoodsParamCust> goodsParamCustList;

    private MultipartFile file;

    private GoodsImage goodsImage;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsTitle getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(GoodsTitle goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public List<GoodsParamCust> getGoodsParamCustList() {
        return goodsParamCustList;
    }

    public void setGoodsParamCustList(List<GoodsParamCust> goodsParamCustList) {
        this.goodsParamCustList = goodsParamCustList;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Classify getClassify() {
        return classify;
    }

    public void setClassify(Classify classify) {
        this.classify = classify;
    }

    public ClassParent getClassParent() {
        return classParent;
    }

    public void setClassParent(ClassParent classParent) {
        this.classParent = classParent;
    }

    public GoodsImage getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(GoodsImage goodsImage) {
        this.goodsImage = goodsImage;
    }
}
