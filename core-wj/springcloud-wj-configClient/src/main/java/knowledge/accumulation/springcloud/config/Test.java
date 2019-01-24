package knowledge.accumulation.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @Autowired
    private TestConfig testConfig;

    @Scheduled(cron = "*/2 * * * * ?")
    public void test1(){
        System.out.println(testConfig.getName());
    }
}
