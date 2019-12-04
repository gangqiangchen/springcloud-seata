package com.springcloud.seata.user.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisBean {

  private StringRedisTemplate template;

  @Autowired
  public RedisBean(StringRedisTemplate template) {
    this.template = template;
  }
}
