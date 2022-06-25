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

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationMain.class})
public class DsTest {

    private final Logger log= LoggerFactory.getLogger(DsTest.class);

    @Autowired
    private QueryHandler queryHandler;

    @Before
    public void before() {
    }
    @Test
    public void test() {

        new Thread(() -> {
            List<Map<String, Object>> list = queryHandler.queryAll();
            System.out.println(list);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }

}
