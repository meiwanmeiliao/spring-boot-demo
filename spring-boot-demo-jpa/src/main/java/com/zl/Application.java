package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/20
 * @description:
 **/
@SpringBootApplication
@ComponentScan("com.zl")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
