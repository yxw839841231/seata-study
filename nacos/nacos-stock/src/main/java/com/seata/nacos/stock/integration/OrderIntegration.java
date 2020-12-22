package com.seata.nacos.stock.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类名 OrderIntegration
 * 描述
 *
 * @Author xwyang
 * @Date 2020/12/15 5:21 下午
 * @Version 1.0
 **/

@FeignClient(name = "nacos-order")
public interface OrderIntegration {
    @PostMapping("/order/add")
    Boolean add(@RequestParam Long goodsId, @RequestParam Long num, @RequestParam String xid);
}
