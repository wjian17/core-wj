package knowledge.accumulation.springcloud.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@EnableScheduling
@Component
public class Producer1 {

    @Autowired
    private RabbitMqConfig1 rabbitMqSender;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static String QUEUE_NAME = "Queue";
    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.95.224.207");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        int i = 100;
        while (i--!=0) {
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }

    @Scheduled(fixedDelay=20000)//每3s执行1次
    public void send() throws Exception{
        String content = new Date().toString();
        rabbitTemplate.convertAndSend("pikachu_e","pikachu_#","send content :"+content);
        rabbitTemplate.convertAndSend("pikachu_e","pikac111hu_#","send content :"+content);
        rabbitTemplate.convertAndSend("pikachu_ekkkk","","send content :"+content);
        rabbitTemplate.convertAndSend("pikachu_e","pikachu_#","send content :"+content);
        rabbitTemplate.convertAndSend("pikachu_ekkkk","pikachu_#","send content :"+content);
        rabbitTemplate.convertAndSend("pikachu_ekkkk","pikachu_#","send content :"+content);
        rabbitTemplate.convertAndSend("pikachu_e","pikachu11_#","send content :"+content);
//        rabbitTemplate.convertAndSend("topic_change","topic_message","send content :"+content);
//        rabbitTemplate.convertAndSend("topic_change","topic_#","send content :"+content);
        rabbitTemplate.convertAndSend("publish_message","publish_message","send content :"+content);
////        this.amqpTemplate .convertAndSend("tp.exchage","topic.massages","topicmessages");
//        rabbitTemplate.convertAndSend("publish_message","publish_message", "send content :"+content,
//                message -> {
//                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
//                    return message;
//                },
//                new CorrelationData(new Date().toString()));
    }

}
