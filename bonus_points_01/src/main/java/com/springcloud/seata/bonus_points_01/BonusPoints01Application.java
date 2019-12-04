package com.springcloud.seata.bonus_points_01;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@EnableDistributedTransaction
@EnableEurekaClient
@SpringBootApplication
@RestController
public class BonusPoints01Application {

    public static void main(String[] args) {
        SpringApplication.run(BonusPoints01Application.class, args);
    }

    @RequestMapping("/getScore")
    Integer getScore() {
        return 101;
    }
}
