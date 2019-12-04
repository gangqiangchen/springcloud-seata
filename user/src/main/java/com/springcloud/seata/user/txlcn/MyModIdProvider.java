package com.springcloud.seata.user.txlcn;

import com.codingapi.txlcn.common.util.id.ModIdProvider;
import org.springframework.stereotype.Component;

/**
 * TC模块标识策略 TC模块在负载时，TM为了区分具体模块，会要求TC注册时提供唯一标识。默认策略是，应用名称加端口方式标识。也可以自定义，自定义需要保证各个模块标识不能重复。
 */
@Component
public class MyModIdProvider implements ModIdProvider {

  @Override
  public String modId() {
    return "user：" + "8081";
  }
}
