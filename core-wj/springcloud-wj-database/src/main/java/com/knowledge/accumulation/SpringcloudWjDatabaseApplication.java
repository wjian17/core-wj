package com.knowledge.accumulation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringcloudWjDatabaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudWjDatabaseApplication.class, args);
    }
}

