package com.springcloud.seata.txlcntm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableTransactionManagerServer
@SpringBootApplication
public class TxlcnTmApplication {

  public static void main(String[] args) {
    SpringApplication.run(TxlcnTmApplication.class, args);
  }

}
