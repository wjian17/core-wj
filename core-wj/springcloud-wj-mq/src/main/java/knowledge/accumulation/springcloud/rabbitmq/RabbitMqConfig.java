package knowledge.accumulation.springcloud.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class RabbitMqConfig implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {
 
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void send(){
        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.setMandatory(true);
    }


    /**
     * 启动消息失败返回，比如路由不到队列时触发回调
     * @param message
     * @param i
     * @param s
     * @param s1
     * @param s2
     */
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("消息从交换机到队列失败" + message.toString()+"==="+i+"==="+s1+"==="+s2);
    }

    /**
     * 确认是否正确到达exchange中
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            System.out.println("HelloSender消息发送失败" + cause);
        } else {
            System.out.println("HelloSender 消息发送成功 "+ cause );
            if(correlationData!=null){
                System.out.println(correlationData.getId());
            }
        }
    }
}
