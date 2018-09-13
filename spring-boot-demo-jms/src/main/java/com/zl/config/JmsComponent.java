package com.zl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;


/**
 * @AUTH zhuolin
 * @DATE 2018/9/10
 * @description:
 **/
@Component
public class JmsComponent {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    @JmsListener(destination = "user.queue")
    public void receiveQueue(String text) {
        System.out.println("接受到：" + text);
    }
}
