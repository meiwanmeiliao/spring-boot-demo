package com.zl.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/11
 * @description:
 **/
@Component
public class JmsConfiguration {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("user.queue");
    }
}
