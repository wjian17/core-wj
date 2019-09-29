package knowledge.accumulation.springcloud;

import knowledge.accumulation.springcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Autowired
    TestService testService;

    @Override
    public void run(String... args) throws Exception {
       testService.test();
    }
}
