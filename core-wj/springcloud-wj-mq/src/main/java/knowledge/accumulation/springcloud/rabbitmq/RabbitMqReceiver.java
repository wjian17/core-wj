package knowledge.accumulation.springcloud.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

//表示对队列hello进行监听，@RabbitHandler指定对消息的处理方法；有坑！！！！！！！！
//https://www.cnblogs.com/lazio10000/p/5559999.html
@Component
public class RabbitMqReceiver {

    ThreadLocal<Integer> calc = new ThreadLocal<Integer>();

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

//    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("pikachu_q"),
//            key = "pikachu_#",
//            exchange = @Exchange("pikachu_e")
//    ))
//    public void execute1(String content){
//        System.out.println("execute1 交换器pikachu_e 路由pikachu_#----------->>>"+content);
//        System.out.println("execute1 交换器pikachu_e 路由pikachu_#----------->>>"+content);
//        System.out.println("execute1 交换器pikachu_e 路由pikachu_#----------->>>"+content);
//    }

//    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("pikachu_q"),
//            key = "pikachu_2",
//            exchange = @Exchange("pikachu_e")
//    ))
//    public void execute2(String content, Channel channel, Message message) throws Exception{
//        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        channel.basicAck(deliveryTag,false);
//        System.out.println("execute2----------->>>"+content);
//    }

//    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("topic_message"),
//            key = "topic_message",
//            exchange = @Exchange("topic_change")
//    ))
//    public void execute3(String content){
//        System.out.println("topic.message----------->>>"+content);
//    }

//    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("topic_messages"),
//            key = "topic_messages",
//            exchange = @Exchange("topic_change")
//    ))
//    public void execute4(String content){
//        System.out.println("topic.messages----------->>>"+content);
//    }

    //    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("publish_message1"),
//            key = "publish_message",
//            exchange = @Exchange("publish_message")
//    ))
//    public void execute5(String content){
//        System.out.println("execute5 交换器publish_message 路由publish_message----------->>>"+content);
//        System.out.println("execute5 交换器publish_message 路由publish_message----------->>>"+content);
//        System.out.println("execute5 交换器publish_message 路由publish_message----------->>>"+content);
//    }
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("publish_message2"),
            key = "publish_message",
            exchange = @Exchange("publish_message")
    ))
    /**
     * 消费者确认：basicAck(long deliveryTag, boolean multiple)，其中deliveryTag 可以看作消息的编号，
     * 它是一个64 位的长整型值；multiple一般设为false，如果设为true则表示确认当前deliveryTag 编号及之前所有未被当前消费者确认的消息。
     *
     * 消费者拒绝：basicNack(long deliveryTag, boolean multiple, boolean requeue)，其中deliveryTag 可以看作消息的编号，
     * 它是一个64 位的长整型值。multiple一般设为false，如果设为true则表示拒绝当前deliveryTag 编号及之前所有未被当前消费者确认的消息。
     * requeue参数表示是否重回队列，如果requeue 参数设置为true ，则RabbitMQ 会重新将这条消息存入队列尾部（注意是队列尾部），
     * 等待继续投递给订阅该队列的消费者，当然也可能是自己；如果requeue 参数设置为false ，则RabbitMQ立即会把消息从队列中移除，
     * 而不会把它发送给新的消费者。
     *
     */
    public void execute6(String content, Channel channel, Message me) throws Exception {
        System.out.println("execute6 交换器publish_message 路由publish_message----------->>>" + content);
        System.out.println("execute6 交换器publish_message 路由publish_message----------->>>" + content);
        System.out.println("execute6 交换器publish_message 路由publish_message----------->>>" + content);
        long deliveryTag = me.getMessageProperties().getDeliveryTag();
        //消息确认
        channel.basicAck(deliveryTag, false);
        //消息失败
        System.out.println("消费端消费确认完毕");

//            channel.basicNack(deliveryTag,false,true);
//            channel.basicNack(deliveryTag,false,false);

    }
//    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("publish_message3"),
//            key = "publish_message",
//            exchange = @Exchange("publish_message")
//    ))
//    public void execute7(String content, Channel channel, Message message) throws IOException {
//        System.out.println("HelloReceiver收到  : " + content +"收到时间"+new Date());
//        System.out.println("execute7 交换器publish_message 路由publish_message----------->>>"+content);
//        System.out.println("execute7 交换器publish_message 路由publish_message----------->>>"+content);
//        System.out.println("execute7 交换器publish_message 路由publish_message----------->>>"+content);
//        try {
//            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//            System.out.println("receiver success");
//        } catch (IOException e) {
//            e.printStackTrace();
//            //丢弃这条消息
//            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
//            System.out.println("消息重发机制");
//            System.out.println("receiver fail");
//        }
//    }

    /**
     * 死信队列和无路由队列
     *     @RabbitHandler
     *     @RabbitListener(bindings = @QueueBinding(
     *             value = @Queue(value = "invoice_message", arguments = {@Argument(name = "x-dead-letter-exchange", value = "exchange-dlx")}),
     *             key = "invoice_message",
     *             exchange = @Exchange(value = "invoice_exchange", arguments = {@Argument(name = "alternate-exchange", value = "exchange-unroute")})
     *     ))
     *
     *     @RabbitHandler
     *     @RabbitListener(bindings = @QueueBinding(
     *             value = @Queue(value = "queue_unroute"),
     *             exchange = @Exchange(value = "exchange-unroute", type = "fanout")
     *     ))
     *
     *         @RabbitHandler
     *     @RabbitListener(bindings = @QueueBinding(
     *             value = @Queue(value = "queue_dlx"),
     *             exchange = @Exchange(value = "exchange-dlx", type = "fanout")
     *     ))
     */
//    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "queue_unroute"),
//            exchange = @Exchange(value = "exchange-unroute", type = "fanout")
//    ))
//    public void unroute(String content, Channel channel, Message me) throws Exception {
//        System.out.println("unroute...");
//        System.out.println("unroute...");
//        System.out.println("unroute...");
//    }
//
//    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "queue_dlx"),
//            exchange = @Exchange(value = "exchange-dlx", type = "fanout")
//    ))
//    public void deadQueue(String content, Channel channel, Message me) throws Exception {
//        System.out.println("dlx......");
//        System.out.println("dlx......");
//        System.out.println("dlx......");
//    }
}
