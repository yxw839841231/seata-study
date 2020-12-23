package com.seata.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 类名 ConsulStockApplication
 * 描述
 *
 * @Author xwyang
 * @Date 2020/12/22 7:12 下午
 * @Version 1.0
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ConsulStockApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulStockApplication.class, args);
    }
}
