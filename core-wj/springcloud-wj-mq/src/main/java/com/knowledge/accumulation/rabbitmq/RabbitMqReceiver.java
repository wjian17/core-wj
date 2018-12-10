package com.knowledge.accumulation.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;
import java.io.IOException;
import java.util.Date;

//表示对队列hello进行监听，@RabbitHandler指定对消息的处理方法；有坑！！！！！！！！
//https://www.cnblogs.com/lazio10000/p/5559999.html
@Component
public class RabbitMqReceiver {

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

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("publish_message1"),
            key = "publish_message",
            exchange = @Exchange("publish_message")
    ))
    public void execute5(String content){
        System.out.println("publish_message1----------->>>"+content);
    }
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("publish_message2"),
            key = "publish_message",
            exchange = @Exchange("publish_message")
    ))
    public void execute6(String content){
        System.out.println("publish_message2----------->>>"+content);
    }
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("publish_message3"),
            key = "publish_message",
            exchange = @Exchange("publish_message")
    ))
    public void execute7(String content, Channel channel, Message message) throws IOException {
        System.out.println("HelloReceiver收到  : " + content +"收到时间"+new Date());
        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("receiver success");
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            System.out.println("receiver fail");
        }
        System.out.println("publish_message3----------->>>"+content);
    }

}
