package com.collection.service;

import com.collection.eo.GoodsImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodsImageService {
    //添加
    public Integer addGoodsImage(GoodsImage goodsImage);

    //修改
    public Integer updateGoodsImage(GoodsImage goodsImage);

    //删除
    public Integer deleteGoodsImageById(Integer id);

    //批量删除
    public Integer deleteGoodsImageByGroup(Integer[] id);

    //精确查询
    public List<GoodsImage> selectGoodsImage(GoodsImage goodsImage);

    //模糊查询
    public List<GoodsImage> queryGoodsImage(GoodsImage goodsImage);

    public String uploadImage(MultipartFile multipartFile);

    //根据goodsId查询
    public List<GoodsImage> selectListGoodsImage(Integer goodsId);

    public GoodsImage selectGoodsImage(Integer goodsId);

    public GoodsImage selectGoodsImageById(Integer id);
}
