package knowledge.accumulation.springcloud.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  * RabbitMQ 生产者
 *  * @author Administrator
 *  * 
 *  
 */
public class Producer {
    //队列名称
    private final static String QUEUE_NAME = "Queue";

    public static void main(String[] args) {
// 创建连接工厂
        ConnectionFactory factory = null;
// 建立到代理服务器到连接
        Connection connection = null;
// 获得通道
        Channel channel = null;
        try {
            factory = new ConnectionFactory();
//设置用户名和密码
            factory.setUsername("guest");
            factory.setPassword("guest");
// 设置 RabbitMQ 地址
            factory.setHost("47.95.224.207");
            factory.setPort(15672);
// 建立到代理服务器到连接
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "hello world .....";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println("发送  message[" + message + "] to " + QUEUE_NAME + " success!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}