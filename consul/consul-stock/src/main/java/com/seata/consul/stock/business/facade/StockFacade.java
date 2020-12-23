package com.seata.consul.stock.business.facade;

import com.seata.consul.stock.business.service.IStockService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名 StockFacade
 * 描述
 *
 * @Author xwyang
 * @Date 2020/12/15 5:13 下午
 * @Version 1.0
 **/
@RestController()
@RequestMapping("/stock")
@Slf4j
public class StockFacade {

    @Autowired
    IStockService service;

    @PostMapping("/sub")
    public Boolean sub(Long goodsId, Long num) {
        // log.info("xid = {}", RootContext.getXID());

        service.sub(goodsId, num);
        // log.info("xid = {}", RootContext.getXID());
        return true;
    }
}
