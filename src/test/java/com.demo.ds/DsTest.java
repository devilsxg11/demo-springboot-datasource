package com.demo.ds;

import com.demo.ds.handler.QueryHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationMain.class})
public class DsTest {

    private final Logger log= LoggerFactory.getLogger(DsTest.class);

    @Autowired
    private QueryHandler queryHandler;


    private ThreadPoolExecutor pool;

    @Before
    public void before() {

        pool = new ThreadPoolExecutor(5, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10), new CustomizableThreadFactory("pool-"),
                new ThreadPoolExecutor.AbortPolicy());
    }
    @Test
    public void test() throws Exception {

        for(int i=0; i<20; i++){
            pool.execute(() -> {
                while (true){
                    long start = System.currentTimeMillis();
                    List<Map<String, Object>> list = queryHandler.queryGroupByName();
                    long end = System.currentTimeMillis();
                    log.info(Thread.currentThread().getName() + ", queryAll, count: {} 条, cost time: {} 毫秒", list.size(), end-start);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        Thread.sleep(50*60*1000);
    }

}
