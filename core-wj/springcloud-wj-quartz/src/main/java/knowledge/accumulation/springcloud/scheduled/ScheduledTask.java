package knowledge.accumulation.springcloud.scheduled;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Scheduled(cron = "3 0 0 */1 * ?")
    public void task(){

    }

}
