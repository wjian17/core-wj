package knowledge.accumulation.springcloud.scheduled;


import knowledge.accumulation.springcloud.quart.QuartJob;
import knowledge.accumulation.springcloud.quart.util.QuartzTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledTaskT {

    @Autowired
    private QuartzTools quartzTools;

    @Scheduled(cron = "*/40 * * * * ?")
    public void task(){
        System.out.println("创建job");
        quartzTools.addJob(new Date().toString(), QuartJob.class,"*/10 * * * * ?");
    }

}
