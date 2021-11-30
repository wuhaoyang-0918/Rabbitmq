package com.mayikt.producer;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName OrderProducer
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@Component
@Slf4j
public class OrderProducer implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        String id = correlationData.getId();
        log.info("id:" + id);
    }

    /**
     * 使用mq发送消息
     *
     * @param orderName
     * @param orderId
     */
    public void sendMsg(String orderName, String orderId) {
        OrderEntity orderEntity = new OrderEntity(orderName, orderId);
        rabbitTemplate.convertAndSend("/mayikt_order", "", orderEntity, message -> {
            return message;
        });
//        CorrelationData correlationData = new CorrelationData();
//        correlationData.setId(JSONObject.toJSONString(orderEntity));
//        rabbitTemplate.convertAndSend("/mayikt_order", "", orderEntity,correlationData);
    }

}
