package knowledge.accumulation.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 */
@EnableFeignClients
@EnableEurekaClient
//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class
        //,org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableSwagger2
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
