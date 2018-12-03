package com.knowledge.accumulation.rabbitmq;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

//表示对队列hello进行监听，@RabbitHandler指定对消息的处理方法；有坑！！！！！！！！
//https://www.cnblogs.com/lazio10000/p/5559999.html
@Component
public class SpringCloudReceiver {

//    @RabbitHandler
//    @RabbitListener(queues = "Queue",containerFactory = "rabbitListenerContainerFactory")
//    public void process(byte[] body) {
//        System.out.println("Receiver:" + new String(body));
//    }


////        @RabbitHandler
//    @RabbitListener(queues = "topic.message")
//    @RabbitHandler
//    public void process1(byte[] body) {
//        System.out.println("Receiver1:" + new String(body));
//    }

//    @RabbitListener(queues = "topic.messages")
//    public void process2(byte[] body) {
//        System.out.println("Receiver1:" + new String(body));
//    }

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("pikachu_q"),
            key = "pikachu_#",
            exchange = @Exchange("pikachu_e")
    ))
    public void execute1(String content){
        System.out.println("execute1----------->>>"+content);
    }

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("pikachu_q"),
            key = "pikachu_2",
            exchange = @Exchange("pikachu_e")
    ))
    public void execute2(String content){
        System.out.println("execute2----------->>>"+content);
    }

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic_message"),
            key = "topic_message",
            exchange = @Exchange("topic_change")
    ))
    public void execute3(String content){
        System.out.println("topic.message----------->>>"+content);
    }

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic_messages"),
            key = "topic_messages",
            exchange = @Exchange("topic_change")
    ))
    public void execute4(String content){
        System.out.println("topic.messages----------->>>"+content);
    }

}
