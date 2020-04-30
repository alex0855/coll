package com.collection.dao;

import com.collection.eo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Testdao {

    public User find(String name);
}
