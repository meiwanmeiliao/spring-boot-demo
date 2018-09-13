package com.zl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/11
 * @description:
 **/
@Component
public class JmsComponent {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend("user.queue", msg);
    }

    @JmsListener(destination = "user.queue")
    public void receiveQueue(String text) throws Exception {
        throw new Exception("aaaaaaaaaaaaaaaa");
//        System.out.println("消息" + ":" + text);
    }

}
