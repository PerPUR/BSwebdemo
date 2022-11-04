package com.example.bswebdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.bswebdemo.BSMapper")
@SpringBootApplication
public class BSwebdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BSwebdemoApplication.class, args);
    }

}
