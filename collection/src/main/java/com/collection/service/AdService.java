package com.collection.service;

import com.collection.eo.Ad;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdService {
    //添加
    public Integer addAd(Ad ad);

    //修改
    public Integer updateAd(Ad ad);

    //删除
    public Integer deleteAdById(Integer id);

    //批量删除
    public Integer deleteAdByGroup(Integer[] id);

    //精确查询
    public List<Ad> selectAd(Ad ad);

    //模糊查询
    public List<Ad> queryAd(Ad ad);

    public Ad selectAdById(Integer id);
    
}
