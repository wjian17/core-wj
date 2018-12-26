package com.knowledge.accumulation.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {

    public void sendTextMessage(String datas) {
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Destination destination = null;
        Destination topicDestination = null;
        Session session = null;
        Message message = null;
        MessageProducer producer = null;
        MessageProducer topicProducer = null;
        try {
            connectionFactory = new ActiveMQConnectionFactory("guest", "guest", "tcp://47.95.224.207:61616");
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
            producer = session.createProducer(destination);
            topicProducer = session.createProducer(topicDestination);
            for(int i=0;i<100;i++) {
                Thread.sleep(100);
                message = session.createTextMessage(datas+i);
                producer.send(message);
                producer.send(message,DeliveryMode.PERSISTENT,9,1000*6);
            }
            for(int i=0;i<100;i++) {
                System.out.println("===========");
                Thread.sleep(100);
                message = session.createTextMessage(datas+i);
                topicProducer.send(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (producer != null)
                    producer.close();
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
    }

    public static void main(String[] args) {
        new Producer().sendTextMessage("111111111111111111111111");
    }
}
