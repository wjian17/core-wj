package knowledge.accumulation.springcloud.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.ArrayList;

public class Consumer {

    public String getMessageText() {
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Destination destination = null;
        Destination topicDestination = null;
        Session session = null;
        Message message = null;
        MessageConsumer consumer = null;
        MessageConsumer topicConsumer = null;
        try {
            connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://47.95.224.207:61616");
            connection = connectionFactory.createConnection();
            connection.start();
            /**
             * 是否支持事务
             * Session.SESSION_TRANSACTIED  第一个参数
             *
             * acknowledgeMode 消息确认机制
             *  AUTO_ACKNOWLEDGE 自动确认
             *  CLIENT_ACKNOWLEDGE 客户手动确认，消费处理必须手动确认
             *  DUPS_OK_ACKNOWLEDGE 副本客户端手动确认
             *      一个消息多次处理
             */
            session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            destination = session.createQueue("first-mq");
            topicDestination = session.createTopic("first-topic");
            consumer = session.createConsumer(destination);
            topicConsumer = session.createConsumer(topicDestination);

            message = consumer.receive();
            consumer.setMessageListener(new MessageListener() {
                /**
                 * 监听后永久有效，前提链接不关闭
                 * 注册多个循环调用监听【多个consumer】
                 * @param message
                 */
                @Override
                public void onMessage(Message message) {
                    TextMessage objectMessage = (TextMessage)message;
                    try {
                        //acknowledge方法，确认消息，通知mq删除对应消息
                        message.acknowledge();
                        System.out.println(objectMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
            topicConsumer.setMessageListener(new MessageListener() {
                /**
                 * 监听后永久有效，前提链接不关闭
                 * 注册多个循环调用监听【多个consumer】
                 * @param message
                 */
                @Override
                public void onMessage(Message message) {
                    System.out.println("======");
                    TextMessage objectMessage = (TextMessage)message;
                    try {
                        //acknowledge方法，确认消息，通知mq删除对应消息
                        message.acknowledge();
                        System.out.println(objectMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
            new ArrayList<>().forEach(e -> System.out.println(e.getClass()));
            //阻塞当前线程，保障不关闭
            System.in.read();
            String result = ((TextMessage)message).getText();
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (consumer != null)
                    consumer.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            try {
                if (session != null)
                    session.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String returnMsg = new Consumer().getMessageText();
        System.out.println(returnMsg);
    }
}
