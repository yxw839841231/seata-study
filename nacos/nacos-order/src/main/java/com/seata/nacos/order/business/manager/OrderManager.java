package com.seata.nacos.order.business.manager;

import com.seata.nacos.order.business.entity.Order;
import com.seata.nacos.order.business.service.IOrderService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类名 OrderManager
 * 描述
 *
 * @Author xwyang
 * @Date 2020/12/16 5:40 下午
 * @Version 1.0
 **/

@Service
@Slf4j
public class OrderManager {


    @Autowired
    IOrderService service;

    @Transactional(rollbackFor = Exception.class)
    public void add(Long goodsId, Long num) {

        log.info("xid={}", RootContext.getXID());

        Order order = new Order();
        order.setGoodsId(goodsId);
        order.setNum(num);
        service.save(order);
    }

}
