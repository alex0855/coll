package com.collection.eo;

public class GoodsImage extends BaseEo {
    private Integer goodsId;
    private String imagePath;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "GoodsImage{" +
                "goodsId=" + goodsId +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
