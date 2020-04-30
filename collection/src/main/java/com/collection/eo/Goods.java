package com.collection.eo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Component
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Goods extends BaseEo{

    private String name;
    private Integer classId;
    private BigDecimal price;
    private Integer number;
    private GoodsTitle goodsTitle;
    private Byte state;
    private Byte audiState;
    private String remark;
    private GoodsImage goodsImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public GoodsTitle getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(GoodsTitle goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getAudiState() {
        return audiState;
    }

    public void setAudiState(Byte audiState) {
        this.audiState = audiState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public GoodsImage getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(GoodsImage goodsImage) {
        this.goodsImage = goodsImage;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", classId=" + classId +
                ", price=" + price +
                ", number=" + number +
                ", goodsTitle=" + goodsTitle +
                ", state=" + state +
                ", audiState=" + audiState +
                ", remark='" + remark + '\'' +
                ", goodsImage=" + goodsImage +
                '}';
    }
}
