package com.mayikt.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FanoutProducer
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@RestController
public class FanoutProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     *
     * @return
     */
    @RequestMapping("/sendMsg")
    public String sendMsg(String msg) {
        /**
         * 1.交换机名称
         * 2.路由key名称
         * 3.发送内容
         */
        amqpTemplate.convertAndSend("/mayikt_ex", "", msg);
        return "success";
    }
}
