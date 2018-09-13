package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/12
 * @description:
 **/
@SpringBootApplication
public class Application implements HealthIndicator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public Health health() {
        return Health.up().withDetail("hello", "world").build();
    }
}
