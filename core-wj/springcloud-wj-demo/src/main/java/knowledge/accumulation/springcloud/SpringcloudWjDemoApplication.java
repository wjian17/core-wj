package knowledge.accumulation.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 */
//@EnableDiscoveryClient
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@EnableWebMvc
public class SpringcloudWjDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudWjDemoApplication.class, args);
    }
}

