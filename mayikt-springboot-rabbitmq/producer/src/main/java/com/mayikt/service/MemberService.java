package com.mayikt.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MemberService
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@RestController
@Slf4j
public class MemberService {


    @RequestMapping("/addMember")
    public String addMember() {
        // 1.数据库插入数据
        log.info(">01数据库中插入一条数据<");
        sendMsg();
        log.info(">04<");
        return "用户注册成功";
    }

    /**
     * 演示系统出错
     *
     * @param age
     * @return
     */
    @RequestMapping("/insertUser")
    public int insertUser(int age) {
        int j = 1 / age;
        return j;
    }

//    public String sms() {
//        log.info(">02<");
//        try {
//            log.info(">正在发送短信..<");
//            Thread.sleep(3000);
//        } catch (Exception e) {
//
//        }
//        log.info(">03<");
//        return "短信发送完成!";
//    }

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String sendMsg() {
        // 向mq中投递一条消息
        /**
         * 1.交换机名称
         * 2.路由key名称
         * 3.发送内容
         */
        JSONObject data = new JSONObject();
        data.put("userId", "12346");
        amqpTemplate.convertAndSend("/mayikt_ex", "", data);
        return "";
    }

}
