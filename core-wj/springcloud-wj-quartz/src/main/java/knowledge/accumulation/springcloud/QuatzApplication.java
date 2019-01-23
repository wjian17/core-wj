package knowledge.accumulation.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableScheduling
public class QuatzApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuatzApplication.class, args);
    }
}
