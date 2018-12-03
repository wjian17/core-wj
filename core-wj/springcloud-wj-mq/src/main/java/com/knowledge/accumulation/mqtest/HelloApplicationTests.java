package com.knowledge.accumulation.mqtest;

import com.knowledge.accumulation.SpringcloudWjMqApplication;
import com.knowledge.accumulation.rabbitmq.SpringCloudSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringcloudWjMqApplication.class)
public class HelloApplicationTests {

    @Autowired
    private SpringCloudSender sender;

    @Test
    public void hello(){
        try {
            sender.send1();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
