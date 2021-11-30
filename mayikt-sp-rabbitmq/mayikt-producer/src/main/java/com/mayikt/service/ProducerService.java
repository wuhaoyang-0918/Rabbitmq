package com.mayikt.service;

import com.mayikt.entity.MsgEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName ProducerService
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@RestController
public class ProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/sendMsg")
    public void sendMsg() {
        /**
         * 参数1 交换机名称
         * 参数2 路由key
         * 参数3 发送内容
         */
        MsgEntity msgEntity = new MsgEntity(UUID.randomUUID().toString(),
                "1234", "181111111", "644064779@qq.com");
        amqpTemplate.convertAndSend("/mayikt_ex", "", msgEntity);
    }
}
