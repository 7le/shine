package com.shine;

import com.shine.redis.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/3/30.
 */
@Component
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring.xml"})
public class RedisTest {

    @Autowired
    protected RedisClient redisClient;

    @Test
    public void test1() {
        //测试redis Hash
        Map<String,String> map=new HashMap<>();
        map.put("google","www.google.cn");
        map.put("baidu","www.baidu.com");
        map.put("sina","www.sina.com");
        redisClient.setHash("website",map);
    }

    @Test
    public void test2() {
        //测试redis
        Long flag=redisClient.expire("HashTest", 60);
        System.out.println(flag);
    }
}
