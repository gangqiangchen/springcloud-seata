package com.springcloud.seata.bonus_points_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BonusPoints01Application {

  public static void main(String[] args) {
    SpringApplication.run(BonusPoints01Application.class, args);
  }

}
