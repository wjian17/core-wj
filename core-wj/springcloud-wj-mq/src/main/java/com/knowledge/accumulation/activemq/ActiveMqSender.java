package com.knowledge.accumulation.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
@EnableScheduling
public class ActiveMqSender {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

//    @Scheduled(fixedDelay=3000)//每3s执行1次
//    public void send() {
//        System.out.println("send");
//        this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ");
//    }

    @Scheduled(fixedDelay=4000)//每3s执行1次
    public void send() {
        System.out.println("send topic");
        this.jmsMessagingTemplate.convertAndSend(this.topic, "nessage");
    }
}
