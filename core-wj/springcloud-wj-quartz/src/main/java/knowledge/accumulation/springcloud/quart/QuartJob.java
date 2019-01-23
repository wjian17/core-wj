package knowledge.accumulation.springcloud.quart;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class QuartJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date());
    }

    public static void main(String[] args) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(QuartJob.class).build();
        //触发器
        //SimpleScheduleBuilder.repeatSecondlyForever()触发时间相当于@Scheduled(cron=);
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?")).build();
//        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever()).build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }


}
