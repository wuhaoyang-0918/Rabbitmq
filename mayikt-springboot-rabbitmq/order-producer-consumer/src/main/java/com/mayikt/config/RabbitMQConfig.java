package com.mayikt.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName RabbitMQConfig
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@Component
public class RabbitMQConfig {
    /**
     * 定义交换机
     */
    private String EXCHANGE_SPRINGBOOT_NAME = "/mayikt_order";


    /**
     * 订单队列
     */
    private String FANOUT_ORDER_QUEUE = "fanout_order_queue";


    /**
     * 配置orderQueue
     *
     * @return
     */
    @Bean
    public Queue orderQueue() {
        return new Queue(FANOUT_ORDER_QUEUE);
    }


    /**
     * 配置fanoutExchange
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_SPRINGBOOT_NAME);
    }

    // 绑定交换机 orderQueue
    @Bean
    public Binding bindingOrderFanoutExchange(Queue orderQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(orderQueue).to(fanoutExchange);
    }

}
