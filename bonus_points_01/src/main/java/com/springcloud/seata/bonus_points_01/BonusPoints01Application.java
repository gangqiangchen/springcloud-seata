package com.springcloud.seata.bonus_points_01;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.springcloud.seata.bonus_points_01.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableTransactionManagement
@EnableDistributedTransaction
@EnableEurekaClient
@SpringBootApplication
@RestController
public class BonusPoints01Application {

    public static void main(String[] args) {
        SpringApplication.run(BonusPoints01Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TestServiceImpl testService;

    @RequestMapping("/getScore")
    Integer getScore() {
        testService.save();
        return 101;
    }
}
