package com.collection.service;

import com.collection.eo.Goods;
import com.collection.util.ServerResponse;
import com.collection.vo.AddGoodsVo;
import com.collection.vo.GoodsDetailVo;
import com.collection.vo.GoodsListVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsService {

    //添加
    public Integer addGoods(Goods goods);

    //修改
    public Integer updateGoods(Goods goods);

    //删除
    public Integer deleteGoodsById(Integer id);

    //批量删除
    public Integer deleteGoodsByGroup(Integer[] id);

    //精确查询
    public List<Goods> selectGoods(Goods goods);

    //模糊查询
    public List<Goods> queryGoods(Goods goods);

    //表格精确查询
    public ServerResponse<PageInfo<Goods>> selectGoodsForm(Goods goods, Page page);

    //表格模糊查询
    public ServerResponse<PageInfo<Goods>> queryGoodsForm(Goods goods, Page page);

    //多参数添加商品
    public Boolean addGoodsManage(AddGoodsVo addGoodsVo);

    public AddGoodsVo showGoodsManage(Integer goodsId);

    public Boolean  updateGoodsManage(AddGoodsVo addGoodsVo);

    //商品列表
    public ServerResponse<List<GoodsListVo>> goodsList();

    //根据商品id查询商品详情
    public ServerResponse<GoodsDetailVo> goodsDetail(Integer id);

    public Goods selectGoodsById(Integer id);
}
