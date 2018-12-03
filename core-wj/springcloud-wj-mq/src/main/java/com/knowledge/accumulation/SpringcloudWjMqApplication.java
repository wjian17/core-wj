package com.knowledge.accumulation;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableRabbit
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableDiscoveryClient
public class SpringcloudWjMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudWjMqApplication.class, args);
    }
}
