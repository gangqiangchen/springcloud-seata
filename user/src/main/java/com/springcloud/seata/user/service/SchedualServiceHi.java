package com.springcloud.seata.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "bonus-points")
public interface SchedualServiceHi {
    @RequestMapping(value = "/getScore",method = RequestMethod.GET)
    Integer sayHiFromClientOne();
}