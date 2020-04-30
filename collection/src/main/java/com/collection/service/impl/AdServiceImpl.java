package com.collection.service.impl;

import com.collection.dao.AdDao;
import com.collection.eo.Ad;
import com.collection.service.AdService;
import com.collection.service.GoodsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;

    @Autowired
    private GoodsImageService goodsImageService;

    public Integer addAd(Ad ad) {
        return adDao.addAd(ad);
    }

    public Integer updateAd(Ad ad) {
        String path = null;
        if(ad.getFile()!=null) {
            path = goodsImageService.uploadImage(ad.getFile());
        }
        ad.setImagePath(path);
        return adDao.updateAd(ad);
    }

    public Integer deleteAdById(Integer id) {
        return adDao.deleteAdById(id);
    }

    public Integer deleteAdByGroup(Integer[] id) {
        return adDao.deleteAdByGroup(id);
    }

    public List<Ad> selectAd(Ad ad) {
        return adDao.selectAd(ad);
    }

    public List<Ad> queryAd(Ad ad) {
        return adDao.queryAd(ad);
    }

    public Ad selectAdById(Integer id) {
        return adDao.selectAdById(id);
    }
}
