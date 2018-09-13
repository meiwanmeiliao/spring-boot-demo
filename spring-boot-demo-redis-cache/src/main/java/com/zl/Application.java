package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/31
 * @description:
 **/
@EnableCaching
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class);

    }
}
