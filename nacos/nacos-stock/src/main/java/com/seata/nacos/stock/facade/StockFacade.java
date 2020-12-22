package com.seata.nacos.stock.facade;

import com.seata.nacos.stock.manager.StockManager;
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
public class StockFacade {

    @Autowired
    StockManager manager;

    @PostMapping("/sub")
    public Boolean sub(Long goodsId, Long num) {
        manager.deal(goodsId, num);
        return true;
    }
}
