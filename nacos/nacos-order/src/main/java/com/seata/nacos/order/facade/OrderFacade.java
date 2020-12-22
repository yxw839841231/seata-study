package com.seata.nacos.order.facade;

import com.seata.nacos.order.business.manager.OrderManager;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名 OrderFacade
 * 描述
 *
 * @Author xwyang
 * @Date 2020/12/15 5:09 下午
 * @Version 1.0
 **/
@RestController()
@RequestMapping("/order")
@Slf4j
public class OrderFacade {

    @Autowired
    OrderManager manager;

    @PostMapping("/add")
    public Boolean add(@RequestParam("goodsId") Long goodsId, @RequestParam("num") Long num, @RequestParam("xid") String xid) {
        log.info("xid={}", RootContext.getXID());
        RootContext.bind(xid);
        manager.add(goodsId, num);
        return true;
    }

}
