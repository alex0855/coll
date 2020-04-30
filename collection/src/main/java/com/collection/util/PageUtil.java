package com.collection.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class PageUtil {

    //分页大小
    private Integer pageSize;

    //分页开始
    private Integer pageNum;

    private Integer total;

    //排序类型DESC  or  AES
    private String sort;

    private String orderBy;

    public Integer getPageSize() {
        return pageSize;
    }

    private static String DEFAULT_SORT="create_time";

    private static String DEFAULT_ORDERBY="create_time DESC";

    private static Integer DEFAULT_PAGESIZE=10;

    private static Integer DEFAULT_PAGENUM=1;

    public static void startPage(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize,DEFAULT_ORDERBY);
    }

    public static void startPage() {
        PageHelper.startPage(DEFAULT_PAGENUM,DEFAULT_PAGESIZE,DEFAULT_ORDERBY);
    }

    public static void initPage(Page page) {
        if(page.getPageNum()==0||page.getPageSize()==0) {
            PageUtil.startPage();
        }else {
            PageUtil.startPage(page.getPageNum(), page.getPageSize());
        }
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
