package com.springcloud.seata.bonus_points_02.txlcn;

import com.codingapi.txlcn.common.util.Maps;
import com.codingapi.txlcn.tc.core.transaction.txc.analy.def.PrimaryKeysProvider;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * TXC模式定义表的实际主键 TXC 是基于逆向sql的方式实现对业务的回滚控制，在逆向sql操作数据是会检索对应记录的主键作为条件处理回滚业务。但是在有些情况下可能表中并没有主键字段(primary
 * key)，仅存在业务上的名义主键，此时可通过重写PrimaryKeysProvider方式定义表对应的主键关系。
 */
@Component
public class MysqlPrimaryKeysProvider implements PrimaryKeysProvider {

  @Override
  public Map<String, List<String>> provide() {
    //t_demo 表的回滚主键为 kid字段
    return Maps.newHashMap("t_demo", Collections.singletonList("kid"));
  }
}