package com.springcloud.seata.user.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.springcloud.seata.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements UserService {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  RestTemplate restTemplate;

  @LcnTransaction
  @Transactional
  @Override
  public void save() {

    jdbcTemplate.execute("INSERT INTO `user_info` VALUES ('5', '李四');");

    restTemplate.getForObject("http://BONUS-POINTS/getScore", Integer.class);
  }
}
