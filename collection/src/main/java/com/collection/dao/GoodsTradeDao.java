package com.collection.dao;

import com.collection.eo.GoodsTrade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsTradeDao {
    //添加
    public Integer addGoodsTrade(GoodsTrade goodsTrade);

    //修改
    public Integer updateGoodsTrade(GoodsTrade goodsTrade);

    //删除
    public Integer deleteGoodsTradeById(Integer id);

    //批量删除
    public Integer deleteGoodsTradeByGroup(Integer[] id);

    //精确查询
    public List<GoodsTrade> selectGoodsTrade(GoodsTrade goodsTrade);

    //模糊查询
    public List<GoodsTrade> queryGoodsTrade(GoodsTrade goodsTrade);
}
