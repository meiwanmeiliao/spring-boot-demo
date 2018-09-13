package com.zl.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/11
 * @description:
 **/
@Configuration
public class AmqpConfiguration {
    @Bean
    public Queue queue() {
        return new Queue("user.queue");
    }
}
