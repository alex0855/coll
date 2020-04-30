package com.collection.service.impl;

import com.collection.dao.GoodsImageDao;
import com.collection.eo.GoodsImage;
import com.collection.service.GoodsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsImageServiceImpl implements GoodsImageService {

    @Autowired
    private GoodsImageDao goodsImageDao;

//    @Autowired
//    private MultipartConfigElement multipartConfigElement;

    @Value("${imagelocal}")
    private String imageLocation;

    public Integer addGoodsImage(GoodsImage goodsImage) {
        goodsImage.setCreateTime(new Date());
        return goodsImageDao.addGoodsImage(goodsImage);
    }

    public Integer updateGoodsImage(GoodsImage goodsImage) {
        return goodsImageDao.updateGoodsImage(goodsImage);
    }

    public Integer deleteGoodsImageById(Integer id) {
        return goodsImageDao.deleteGoodsImageById(id);
    }

    public Integer deleteGoodsImageByGroup(Integer[] id) {
        return goodsImageDao.deleteGoodsImageByGroup(id);
    }

    public List<GoodsImage> selectGoodsImage(GoodsImage goodsImage) {
        return goodsImageDao.selectGoodsImage(goodsImage);
    }

    public List<GoodsImage> queryGoodsImage(GoodsImage goodsImage) {
        return goodsImageDao.queryGoodsImage(goodsImage);
    }

    //处理上传图片到指定路径
    public String uploadImage(MultipartFile multipartFile){
        //获取文件名
        String fileName = multipartFile.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //目录
//        String location = multipartConfigElement.getLocation();
        String rootPath = imageLocation+"/images/";
        File rootFile = new File(rootPath);
        if (!rootFile.exists()) {
            rootFile.mkdirs();
        }
        //goods_image的文件路径
        String filePath =  fileName;

        File file = new File(rootPath+fileName);


        if(!file.exists()){
            try {
                multipartFile.transferTo(file);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return filePath;
    }

    public List<GoodsImage> selectListGoodsImage(Integer goodsId) {
        return goodsImageDao.selectListByGoodsId(goodsId);
    }

    public GoodsImage selectGoodsImage(Integer goodsId) {
        return goodsImageDao.selectByGoodsId(goodsId);
    }

    public GoodsImage selectGoodsImageById(Integer id) {
        return goodsImageDao.selectGoodsImageById(id);
    }
}
