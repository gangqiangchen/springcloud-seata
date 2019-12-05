package com.springcloud.seata.bonus_points_02.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.springcloud.seata.bonus_points_02.service.TestService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TestServiceImpl implements TestService {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
  @Transactional
  @Override
  public void save() {
//    jdbcTemplate.execute("INSERT INTO `points` VALUES ('3', '2', '0');");
    System.out.println("bonus_points_02: 开始执行...");
    jdbcTemplate.execute("INSERT INTO `points` (id, uid, score) VALUES ('3', '2', '0');");
    System.out.println("bonus_points_02: 执行完成。");
  }
}
