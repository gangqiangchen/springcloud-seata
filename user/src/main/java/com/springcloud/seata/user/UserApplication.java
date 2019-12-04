package com.springcloud.seata.user;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.springcloud.seata.user.service.impl.UserServiceImpl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableTransactionManagement
@EnableDistributedTransaction
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping({"/", "/user"})
    Object[] helloUser() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from `user_info`");
        System.out.println(maps.toArray());

//        stringRedisTemplate.opsForValue().set("aaa", "123");
//        restTemplate.getForObject("http://BONUS-POINTS/getScore", Integer.class);

        // ##
        // 分布式事务测试
        userServiceImpl.save();
        return maps.toArray();
    }

}
