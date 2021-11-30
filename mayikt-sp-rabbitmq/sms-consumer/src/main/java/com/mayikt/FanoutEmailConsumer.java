package com.mayikt;

import com.mayikt.entity.MsgEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FanoutSmsConsumer
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@Slf4j
@Component
@RabbitListener(queues = "fanout_sms_queue")
public class FanoutEmailConsumer {

    @RabbitHandler
    public void process(MsgEntity msgEntity) {
        log.info("sms：msgEntity:" + msgEntity);
    }
}
