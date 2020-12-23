package com.seata.consul.stock.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seata.consul.stock.business.entity.Stock;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xwyang
 * @since 2020-12-15
 */
public interface IStockService extends IService<Stock> {

    @Transactional
    void sub(Long goodsId, Long num);
}
