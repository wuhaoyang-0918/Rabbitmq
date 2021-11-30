package com.mayikt.producer;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderProducer
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@RestController
public class OrderProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 订单交换机
     */
    @Value("${mayikt.order.exchange}")
    private String orderExchange;
    /**
     * 订单路由key
     */
    @Value("${mayikt.order.routingKey}")
    private String orderRoutingKey;

    @RequestMapping("/sendOrder")
    public String sendOrder() {
        String msg = "每特教育牛逼";
        rabbitTemplate.convertAndSend(orderExchange, orderRoutingKey, msg, message -> {
            // 设置消息过期时间 10秒过期
            message.getMessageProperties().setExpiration("10000");
            return message;
        });
        return "success";
    }
}
