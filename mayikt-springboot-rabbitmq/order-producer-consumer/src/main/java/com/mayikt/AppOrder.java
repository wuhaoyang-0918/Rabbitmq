package com.mayikt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName AppOrder
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@SpringBootApplication
@MapperScan("com.mayikt.mapper")
public class AppOrder {
    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class);
    }
}
