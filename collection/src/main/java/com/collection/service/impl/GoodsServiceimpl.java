package com.collection.service.impl;

import com.collection.dao.GoodsDao;
import com.collection.eo.*;
import com.collection.service.*;
import com.collection.util.PageUtil;
import com.collection.util.ServerResponse;
import com.collection.vo.AddGoodsVo;
import com.collection.vo.GoodsDetailVo;
import com.collection.vo.GoodsListVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class GoodsServiceimpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodsTitleService goodsTitleService;

    @Autowired
    private GoodsParamCustService goodsParamCustService;

    @Autowired
    private GoodsImageService goodsImageService;

    @Autowired
    private StandardService standardService;

    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private ClassParentService classParentService;

    @Autowired
    private GoodsParamService goodsParamService;

    public Integer addGoods(Goods goods) {
        goods.setCreateTime(new Date());
        return goodsDao.addGoods(goods);
    }

    public Integer updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }

    public Integer deleteGoodsById(Integer id) {
        return goodsDao.deleteGoodsById(id);
    }

    public Integer deleteGoodsByGroup(Integer[] id) {
        return goodsDao.deleteGoodsByGroup(id);
    }

    public List<Goods> selectGoods(Goods goods) {
        return goodsDao.selectGoods(goods);
    }

    public List<Goods> queryGoods(Goods goods) {
        return goodsDao.queryGoods(goods);
    }


    //id查询
    public Goods selectOne(Integer id) {
        Goods goods = new Goods();
        goods.setId(id);
        List<Goods> goodsList = goodsDao.selectGoods(goods);
        return goodsList.get(0);
    }

    //表格精确查询
    public ServerResponse<PageInfo<Goods>> selectGoodsForm(Goods goods, Page page) {
        PageUtil.initPage(page);
        List<Goods> goodsList = goodsDao.selectGoods(goods);

        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goodsList);
        ServerResponse<PageInfo<Goods>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    //表格模糊查询
    public ServerResponse<PageInfo<Goods>> queryGoodsForm(Goods goods, Page page) {
        PageUtil.initPage(page);
        List<Goods> goodsList = goodsDao.queryGoods(goods);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goodsList);
        ServerResponse<PageInfo<Goods>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    public Boolean addGoodsManage(AddGoodsVo addGoodsVo) {
        Goods goods = addGoodsVo.getGoods();
        GoodsTitle goodsTitle = addGoodsVo.getGoodsTitle();
        List<GoodsParamCust> goodsParamCustList = addGoodsVo.getGoodsParamCustList();
        MultipartFile multipartFile = addGoodsVo.getFile();
        GoodsImage goodsImage = new GoodsImage();
        if(addGoods(goods)>0){
            //设置商品标题的goodsId
            goodsTitle.setGoodsId(goods.getId());
            //设置图片的商品id
            goodsImage.setGoodsId(goods.getId());
        }else {
            return false;
        }
        if (goodsTitleService.addGoodsTitle(goodsTitle)>0) {
            //设置商品的标题id
            goods.setGoodsTitle(goodsTitle);
            goodsDao.updateGoods(goods);
            //循环添加商品参数
            if(goodsParamCustList!=null) {
                for (GoodsParamCust cust : goodsParamCustList) {
                    cust.setGoodsId(goods.getId());
                    //获得参数名字
                    GoodsParam goodsParam = goodsParamService.selectGoodsParamById(cust.getGoodsParamId());
                    cust.setGoodsParamName(goodsParam.getGoodsParamName());
                    if (goodsParamCustService.addGoodsParamCust(cust) > 0) {
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        String filePath = null;
        if(multipartFile!=null) {
            filePath = goodsImageService.uploadImage(multipartFile);
        }
        goodsImage.setImagePath(filePath);
        if (goodsImageService.addGoodsImage(goodsImage) <= 0) {
                return false;
        }
        goods.setGoodsImage(goodsImage);
        goodsDao.updateGoods(goods);
        return true;
    }

    public AddGoodsVo showGoodsManage(Integer goodsId) {
        AddGoodsVo addGoodsVo = new AddGoodsVo();
        Goods goods = goodsDao.selectGoodsById(goodsId);
        addGoodsVo.setGoods(goods);
        if (goods != null) {
            GoodsTitle goodsTitle = goodsTitleService.selectGoodsTitleByGoodsId(goods.getId());
            addGoodsVo.setGoodsTitle(goodsTitle);
            GoodsImage goodsImage = goodsImageService.selectGoodsImage(goods.getId());
            addGoodsVo.setGoodsImage(goodsImage);
            List<GoodsParamCust> goodsParamCustList = goodsParamCustService.selectGoodsParamCustByGoodsId(goodsId);
            addGoodsVo.setGoodsParamCustList(goodsParamCustList);
            Classify classify = classifyService.selectClassifyById(goods.getClassId());
            ClassParent classParent = new ClassParent();
            if(classify!=null) {
                classParent = classParentService.selectClassifyParentById(classify.getParentId());
            }
            addGoodsVo.setClassify(classify);
            addGoodsVo.setClassParent(classParent);
        }
        return addGoodsVo;
    }

    public Boolean updateGoodsManage(AddGoodsVo addGoodsVo) {
        Goods goods = addGoodsVo.getGoods();
        GoodsTitle goodsTitle = addGoodsVo.getGoodsTitle();
        List<GoodsParamCust> goodsParamCustList = addGoodsVo.getGoodsParamCustList();
        MultipartFile multipartFile = addGoodsVo.getFile();

        goods.setGoodsTitle(goodsTitle);
        goodsDao.updateGoods(goods);
        goodsTitleService.updateGoodsTitle(goodsTitle);

        if (goodsParamCustList!=null&&goodsParamCustList.size() > 0) {
            for (GoodsParamCust cust : goodsParamCustList) {
                cust.setGoodsId(goods.getId());
                //获得参数名字
                GoodsParam goodsParam = goodsParamService.selectGoodsParamById(cust.getGoodsParamId());
                cust.setGoodsParamName(goodsParam.getGoodsParamName());
                goodsParamCustService.addGoodsParamCust(cust);
            }
        }
        GoodsImage selectGoodsImage = addGoodsVo.getGoodsImage();
        if(selectGoodsImage==null||goodsImageService.selectGoodsImageById(selectGoodsImage.getId())==null){
            GoodsImage goodsImage = goodsImageService.selectGoodsImage(goods.getId());
            String filePath = null;
            if(multipartFile!=null) {
                filePath = goodsImageService.uploadImage(multipartFile);
            }
            goodsImage.setImagePath(filePath);
            if (goodsImageService.updateGoodsImage(goodsImage) <= 0) {
                return false;
            }
            goods.setGoodsImage(goodsImage);
            goodsDao.updateGoods(goods);
        }
        return true;
    }

    public ServerResponse<List<GoodsListVo>> goodsList() {
        List<GoodsListVo> goodsListVoList = new ArrayList<GoodsListVo>();
        List<Goods> goodsList = selectGoods(new Goods());
        Collections.reverse(goodsList);
        for (Goods goods : goodsList) {
            GoodsListVo goodsListVo = new GoodsListVo();
            goodsListVo.setGoods(goods);
//            商品图片
            GoodsImage goodsImage = new GoodsImage();
            goodsImage.setGoodsId(goods.getId());
            List<GoodsImage> goodsImageList = goodsImageService.selectGoodsImage(goodsImage);
            if(goodsImageList.size()>0) {
                goodsImage = goodsImageList.get(0);
            }
            goodsListVo.setGoodsImage(goodsImage);
            //标题
            GoodsTitle goodsTitle = new GoodsTitle();
            goodsTitle.setGoodsId(goods.getId());
            List<GoodsTitle> goodsTitleList = goodsTitleService.selectGoodsTitle(goodsTitle);
            if(goodsImageList.size()>0) {
                goodsTitle = goodsTitleList.get(0);
            }
            goodsListVo.setGoodsTitle(goodsTitle);
            goodsListVoList.add(goodsListVo);
        }
        ServerResponse<List<GoodsListVo>> response = ServerResponse.createBySuccess(goodsListVoList);
        return response;
    }

    public ServerResponse<GoodsDetailVo> goodsDetail(Integer id) {
        GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
        Goods goods = goodsDao.selectGoodsById(id);
        if (goods == null || goods.getId()==null) {
            return null;
        }
        GoodsImage goodsImage = goodsImageService.selectGoodsImage(goods.getId());
        GoodsTitle goodsTitle = goodsTitleService.selectGoodsTitleByGoodsId(goods.getId());

        GoodsParamCust goodsParamCust = new GoodsParamCust();
        goodsParamCust.setGoodsId(goods.getId());
        List<GoodsParamCust> goodsParamCustList = goodsParamCustService.selectGoodsParamCust(goodsParamCust);

        Standard standard = new Standard();
        standard.setGoods(goods);
        List<Standard> standardList = standardService.selectStandard(standard);

        goodsDetailVo.setGoods(goods);
        goodsDetailVo.setGoodsImage(goodsImage);
        goodsDetailVo.setGoodsTitle(goodsTitle);
        goodsDetailVo.setGoodsParamCustList(goodsParamCustList);
        goodsDetailVo.setStandardList(standardList);

        ServerResponse<GoodsDetailVo> response = ServerResponse.createBySuccess(goodsDetailVo);
;        return response;
    }

    public Goods selectGoodsById(Integer id) {
        return goodsDao.selectGoodsById(id);
    }
}
