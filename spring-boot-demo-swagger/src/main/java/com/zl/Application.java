package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/12
 * @description:
 **/
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.zl")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
