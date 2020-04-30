package com.collection.eo;

import org.springframework.stereotype.Component;

@Component
public class GoodsTitle extends BaseEo{

    private Integer Id;
    private String titleName;
    private Integer goodsId;
    private String area;
    private String keyword;

    @Override
    public Integer getId() {
        return Id;
    }

    @Override
    public void setId(Integer id) {
        Id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "GoodsTitle{" +
                "Id=" + Id +
                ", titleName='" + titleName + '\'' +
                ", goodsId=" + goodsId +
                ", area='" + area + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
