package com.seata.nacos.order.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.nacos.order.business.entity.Order;
import com.seata.nacos.order.business.mapper.OrderMapper;
import com.seata.nacos.order.business.service.IOrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
