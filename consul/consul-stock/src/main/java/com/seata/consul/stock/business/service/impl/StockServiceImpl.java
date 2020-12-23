package com.seata.consul.stock.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.consul.stock.business.entity.Stock;
import com.seata.consul.stock.business.facade.OrderIntegration;
import com.seata.consul.stock.business.mapper.StockMapper;
import com.seata.consul.stock.business.service.IStockService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xwyang
 * @since 2020-12-15
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {


    @Autowired
    OrderIntegration integration;


    @Override
    @GlobalTransactional
    public void sub(Long goodsId, Long num) {
        integration.add(goodsId, num, RootContext.getXID());

        QueryWrapper queryWrapper = new QueryWrapper<Stock>();
        queryWrapper.eq("goods_id", goodsId);
        Stock stock = getOne(queryWrapper);
        if (stock == null || stock.getNum().compareTo(num) < 0) {
            throw new RuntimeException("商品不存在或库存不足");
        }
        stock.setNum(stock.getNum() - num);

        this.updateById(stock);
    }

}
