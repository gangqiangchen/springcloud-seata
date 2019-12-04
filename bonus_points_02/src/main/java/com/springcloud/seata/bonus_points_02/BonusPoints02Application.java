package com.springcloud.seata.bonus_points_02;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDistributedTransaction
@EnableEurekaClient
@SpringBootApplication
@RestController
public class BonusPoints02Application {

    public static void main(String[] args) {
        SpringApplication.run(BonusPoints02Application.class, args);
    }

    @RequestMapping("/getScore")
    Integer getScore() {
        return 102;
    }

}
