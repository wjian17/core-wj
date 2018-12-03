package com.knowledge.accumulation.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.*;

/**
 *  * RabbitMQ 消费者
 *  * @author Administrator
 *  *
 *  
 */
public class Consumer {
    //队列名称
    private final static String QUEUE_NAME = "Queue";

    static Channel channel = null;

    public static void main(String[] args) {
// 创建连接工厂
        ConnectionFactory factory = null;
// 建立到代理服务器到连接
        Connection connection = null;
// 获得通道
        try {
            factory = new ConnectionFactory();
            factory.setUsername("guest");
            factory.setPassword("guest");
            factory.setHost("localhost");
//            factory.setPort(5672);
// 建立到代理服务器到连接
            connection = factory.newConnection();
            channel = connection.createChannel();
// 1.队列名2.是否持久化，3是否局限与链接，4不再使用是否删除，5其他的属性
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
// 声明一个消费者,配置好获取消息的方式
            boolean autoAck = false;
            channel.basicConsume(QUEUE_NAME, autoAck, "myConsumerTag",
                    new DefaultConsumer(channel) {
                        @Override
                        public void handleDelivery(String consumerTag,
                                                   Envelope envelope,
                                                   AMQP.BasicProperties properties,
                                                   byte[] body)
                                throws IOException {
                            System.out.println(body.toString());
                            String routingKey = envelope.getRoutingKey();
                            String contentType = properties.getContentType();
                            long deliveryTag = envelope.getDeliveryTag();
                            // (process the message components here ...)
                            channel.basicAck(deliveryTag, false);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (ShutdownSignalException e) {
            e.printStackTrace();
        } finally {
            try {
// 关闭资源
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