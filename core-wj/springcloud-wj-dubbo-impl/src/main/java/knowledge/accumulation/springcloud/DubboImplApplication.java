package knowledge.accumulation.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@MapperScan("knowledge.accumulation.springcloud.mapper")
@EnableDubboConfiguration
@SpringBootApplication
public class DubboImplApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboImplApplication.class, args);
    }
}
