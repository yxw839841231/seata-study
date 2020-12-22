package com.seata.nacos.stock.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seata.nacos.stock.business.entity.Stock;
import com.seata.nacos.stock.business.service.IStockService;
import com.seata.nacos.stock.integration.OrderIntegration;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类名 StockManager
 * 描述
 *
 * @Author xwyang
 * @Date 2020/12/18 2:40 下午
 * @Version 1.0
 **/
@Service
@Slf4j
public class StockManager {

    @Autowired
    private OrderIntegration integration;

    @Autowired
    IStockService service;

    @GlobalTransactional()
    @Transactional(rollbackFor = Exception.class)
    public void deal(Long goodsId, Long num) {
        log.info("xid={}", RootContext.getXID());
        integration.add(goodsId, num,RootContext.getXID());
        QueryWrapper queryWrapper = new QueryWrapper<Stock>();
        queryWrapper.eq("goods_id", goodsId);
        Stock stock = service.getOne(queryWrapper);
        if (stock == null || stock.getNum().compareTo(num) < 0) {
            throw new RuntimeException("商品不存在或库存不足");
        }
        stock.setNum(stock.getNum() - num);
        service.updateById(stock);
    }
}
