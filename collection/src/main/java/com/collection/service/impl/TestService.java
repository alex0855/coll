package com.collection.service.impl;

import com.collection.dao.Testdao;
import com.collection.eo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private Testdao testdao;

    public User find(String name){
        return testdao.find(name);
    }
}
