package com.collection.service.impl;

import com.collection.dao.GoodsParamDao;
import com.collection.eo.GoodsParam;
import com.collection.service.GoodsParamService;
import com.collection.util.PageUtil;
import com.collection.util.ServerResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsParamServiceImpl implements GoodsParamService {

    @Autowired
    private GoodsParamDao goodsParamDao;

    public Integer addGoodsParam(GoodsParam goodsParam) {
        goodsParam.setCreateTime(new Date());
        return goodsParamDao.addGoodsParam(goodsParam);
    }

    public Integer updateGoodsParam(GoodsParam goodsParam) {
        return goodsParamDao.updateGoodsParam(goodsParam);
    }

    public Integer deleteGoodsParamById(Integer id) {
        return goodsParamDao.deleteGoodsParamById(id);
    }

    public Integer deleteGoodsParamByGroup(Integer[] id) {
        return goodsParamDao.deleteGoodsParamByGroup(id);
    }

    public List<GoodsParam> selectGoodsParam(GoodsParam goodsParam) {
        return goodsParamDao.selectGoodsParam(goodsParam);
    }

    public List<GoodsParam> queryGoodsParam(GoodsParam goodsParam) {
        return goodsParamDao.queryGoodsParam(goodsParam);
    }

    //id查询
    public GoodsParam selectOne(Integer id) {
        GoodsParam goodsParam = new GoodsParam();
        goodsParam.setId(id);
        List<GoodsParam> goodsParamList = goodsParamDao.selectGoodsParam(goodsParam);
        return goodsParamList.get(0);
    }

    //表格精确查询
    public ServerResponse<PageInfo<GoodsParam>> selectGoodsParamForm(GoodsParam goodsParam, Page page) {
        PageUtil.initPage(page);
        List<GoodsParam> goodsParamList = goodsParamDao.selectGoodsParam(goodsParam);
        PageInfo<GoodsParam> pageInfo = new PageInfo<GoodsParam>(goodsParamList);
        ServerResponse<PageInfo<GoodsParam>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    //表格模糊查询
    public ServerResponse<PageInfo<GoodsParam>> queryGoodsParamForm(GoodsParam goodsParam, Page page) {
        PageUtil.initPage(page);
        List<GoodsParam> goodsParamList = goodsParamDao.queryGoodsParam(goodsParam);
        PageInfo<GoodsParam> pageInfo = new PageInfo<GoodsParam>(goodsParamList);
        ServerResponse<PageInfo<GoodsParam>> serverResponse = ServerResponse.createBySuccess(pageInfo);
        return serverResponse;
    }

    public GoodsParam selectGoodsParamById(Integer id) {
        return goodsParamDao.selectGoodsParamById(id);
    }
}
