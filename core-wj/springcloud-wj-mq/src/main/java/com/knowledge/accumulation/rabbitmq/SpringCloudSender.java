package com.knowledge.accumulation.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SpringCloudSender {
 
    @Autowired
    private AmqpTemplate amqpTemplate;
 
    public void send(){
        String content = "hello" + new Date();
        System.out.println("Sender:" +content);
        this.amqpTemplate.convertAndSend("Query", content);
    }

//    第一个参数是exchange，第二个参数是routingkey，第三个参数是发送的消息message
    public void send1() throws Exception{
        String content = "hello" + new Date();
        System.out.println("sender:"+content);
//        this.amqpTemplate .convertAndSend("tp.exchage","topic.massage","topicmessage");
        amqpTemplate.convertAndSend("pikachu_e","pikachu_1","send content :"+content);
        amqpTemplate.convertAndSend("pikachu_e","pikachu_#","send content :"+content);
        amqpTemplate.convertAndSend("topic_change","topic_message","send content :"+content);
        amqpTemplate.convertAndSend("topic_change","topic_#","send content :"+content);
//        this.amqpTemplate .convertAndSend("tp.exchage","topic.massages","topicmessages");
    }


}
