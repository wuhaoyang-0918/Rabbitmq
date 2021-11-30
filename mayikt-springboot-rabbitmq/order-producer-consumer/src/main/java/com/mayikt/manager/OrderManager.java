package com.mayikt.manager;

import com.mayikt.entity.OrderEntity;
import com.mayikt.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName OrderManager
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@Component
public class OrderManager {
    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public int addOrder(OrderEntity orderEntity) {
        return orderMapper.addOrder(orderEntity);
    }
}
