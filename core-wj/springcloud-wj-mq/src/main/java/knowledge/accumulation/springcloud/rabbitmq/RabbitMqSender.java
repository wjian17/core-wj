package knowledge.accumulation.springcloud.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RabbitMqSender implements RabbitTemplate.ReturnCallback {
 
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
        ((RabbitTemplate)this.amqpTemplate).setReturnCallback(this);
        ((RabbitTemplate)this.amqpTemplate).setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                System.out.println("HelloSender消息发送失败" + cause + correlationData.toString());
            } else {
                System.out.println("HelloSender 消息发送成功 ");
            }
        });
//        this.amqpTemplate .convertAndSend("tp.exchage","topic.massage","topicmessage");
        amqpTemplate.convertAndSend("pikachu_e","pikachu_1","send content :"+content);
        amqpTemplate.convertAndSend("pikachu_e","pikachu_#","send content :"+content);
        amqpTemplate.convertAndSend("topic_change","topic_message","send content :"+content);
        amqpTemplate.convertAndSend("topic_change","topic_#","send content :"+content);
        amqpTemplate.convertAndSend("publish_message","publish_message","send content :"+content);
//        this.amqpTemplate .convertAndSend("tp.exchage","topic.massages","topicmessages");
    }


    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("sender return success" + message.toString()+"==="+i+"==="+s1+"==="+s2);
    }
}
