package com.mayikt;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName fanout_sms_queue
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@Slf4j
@Component
@RabbitListener(queues = "fanout_coupon_queue")
public class FanoutCouponConsumer {

    @RabbitHandler
    public void process(JSONObject msg) {
        log.info(">>调用接口发送优惠券:{}<<", msg.toJSONString());
    }
}
