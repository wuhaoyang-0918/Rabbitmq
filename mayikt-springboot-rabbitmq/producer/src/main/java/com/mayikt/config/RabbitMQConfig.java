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
    private String EXCHANGE_SPRINGBOOT_NAME = "/mayikt_ex";


    /**
     * 短信队列
     */
    private String FANOUT_SMS_QUEUE = "fanout_sms_queue";
    /**
     * coupon队列
     */
    private String FANOUT_COUPON_QUEUE = "fanout_coupon_queue";

    /**
     * 配置smsQueue
     *
     * @return
     */
    @Bean
    public Queue smsQueue() {
        return new Queue(FANOUT_SMS_QUEUE);
    }

    /**
     * 配置优惠券
     *
     * @return
     */
    @Bean
    public Queue couponQueue() {
        return new Queue(FANOUT_COUPON_QUEUE);
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

    // 绑定交换机 sms
    @Bean
    public Binding bindingSmsFanoutExchange(Queue smsQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(smsQueue).to(fanoutExchange);
    }

    // 绑定交换机 COUPON
    @Bean
    public Binding bindingEmailFanoutExchange(Queue couponQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(couponQueue).to(fanoutExchange);
    }
}
