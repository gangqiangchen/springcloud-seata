package com.springcloud.seata.user.bean;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcBean {

  private final JdbcTemplate jdbcTemplate;

  public JdbcBean(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
}
