package com.demo.ds;

import com.demo.ds.service.QueryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationMain.class})
public class DsTest3 {

    private final Logger log= LoggerFactory.getLogger(DsTest.class);

    @Autowired
    private QueryService queryService;

    @Before
    public void before() {

    }
    @Test
    public void test() throws Exception {
        queryService.trans();
    }

}
