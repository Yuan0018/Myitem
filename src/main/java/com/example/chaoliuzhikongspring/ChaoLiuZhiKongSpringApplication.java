package com.example.chaoliuzhikongspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.chaoliuzhikongspring.mapper")
public class ChaoLiuZhiKongSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChaoLiuZhiKongSpringApplication.class, args);
    }

}
