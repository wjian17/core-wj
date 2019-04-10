package knowledge.accumulation.springcloud.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class Producer1 {

    @Autowired
    private RabbitMqSender rabbitMqSender;

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
        System.out.println("send topic");
        this.rabbitMqSender.send();
        this.rabbitMqSender.send1();
    }
}
