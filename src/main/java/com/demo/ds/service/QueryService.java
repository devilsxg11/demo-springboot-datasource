package com.demo.ds.service;

import com.demo.ds.handler.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QueryService {

    @Autowired
    private QueryHandler queryHandler;


    @Transactional
    public void trans() throws InterruptedException {
        queryHandler.queryGroupByName();
        Thread.sleep(5000);
    }
}
