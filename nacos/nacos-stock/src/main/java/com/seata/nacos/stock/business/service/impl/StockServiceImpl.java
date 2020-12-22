package com.seata.nacos.stock.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.nacos.stock.business.entity.Stock;
import com.seata.nacos.stock.business.mapper.StockMapper;
import com.seata.nacos.stock.business.service.IStockService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xwyang
 * @since 2020-12-15
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {

}
