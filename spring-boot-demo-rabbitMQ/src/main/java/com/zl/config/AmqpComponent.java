package com.zl.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/11
 * @description:
 **/
@Component
public class AmqpComponent {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
        this.amqpTemplate.convertAndSend("user.queue", msg);
    }

    @RabbitListener(queues = "user.queue")
    public void receiveQueue(String text) throws Exception {
//        throw  new Exception("a");
        System.out.println("消息1" + text);

    }

    @RabbitListener(queues = "user.queue")
    public void receiveQueue1(String text) throws Exception {
//        throw  new Exception("a");
        System.out.println("消息2" + text);

    }

}
