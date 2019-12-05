package com.springcloud.seata.user.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.springcloud.seata.user.service.SchedualServiceHi;
import com.springcloud.seata.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @LcnTransaction(propagation = DTXPropagation.REQUIRED)
    @Transactional
    @Override
    public void save() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                schedualServiceHi.sayHiFromClientOne();
            }
        });
        thread.start();

        System.out.println("user: 开始执行...");
        jdbcTemplate.execute("INSERT INTO `user_info` VALUES ('6', '李四');");
        System.out.println("user: 开始执行完成。");

//    restTemplate.getForObject("http://BONUS-POINTS/getScore", Integer.class);
    }
}
