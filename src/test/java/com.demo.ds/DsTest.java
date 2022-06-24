package com.demo.ds;

import com.demo.ds.handler.QueryHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright：dp.com
 * Author: SongXiaoGuang
 * Date: 2022/6/24.
 * Description:
 */
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
@SpringBootTest(classes = {DsTest.class})
public class DsTest {

    private final Logger log= LoggerFactory.getLogger(DsTest.class);

    @Autowired
    private QueryHandler queryHandler;

    @Before
    public void before() {
        System.out.println("单元测试开始");
    }
    @Test
    public void test() {
        queryHandler.queryAll();
    }

}
