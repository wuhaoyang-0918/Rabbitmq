package com.mayikt.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName MsgEntity
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@Data
public class MsgEntity implements Serializable {
    private String msgId;
    private String userId;
    private String phone;
    private String email;

    public MsgEntity(String msgId, String userId, String phone, String email) {
        this.msgId = msgId;
        this.userId = userId;
        this.phone = phone;
        this.email = email;
    }
}
