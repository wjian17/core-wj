定时任务

导入pom

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>5.1.2.RELEASE</version>
        </dependency>
        springboot中默认导入 启动器

@EnableScheduling 启动类添加注解
@Scheduled(cron = "3 0 0 */1 * * ?")  任务方法添加注解
属性会自动注入，springboot中

一、结构
corn从左到右（用空格隔开）：秒 分 小时 月份中的日期 月份 星期中的日期 年份


=====================各字段的含义：========================
=====================各字段的含义：========================
=====================各字段的含义：========================　
字段	允许值	允许的特殊字符
秒（Seconds）	0~59的整数	, - * /    四个字符
分（Minutes）	0~59的整数	, - * /    四个字符
小时（Hours）	0~23的整数	, - * /    四个字符
日期（DayofMonth）	1~31的整数（但是你需要考虑你月的天数）	,- * ? / L W C     八个字符
月份（Month）	1~12的整数或者 JAN-DEC	, - * /    四个字符
星期（DayofWeek）	1~7的整数或者 SUN-SAT （1=SUN）	, - * ? / L C #     八个字符
年(可选，留空)（Year）	1970~2099	, - * /    四个字符


=====================注意事项：========================
=====================注意事项：========================
=====================注意事项：========================
每一个域都使用数字，但还可以出现如下特殊字符，它们的含义是：

（1）*：表示匹配该域的任意值。假如在Minutes域使用*, 即表示每分钟都会触发事件。
（2）?：只能用在DayofMonth和DayofWeek两个域。它也匹配域的任意值，但实际不会。因为DayofMonth和DayofWeek会相互影响。例如想在每月的20日触发调度，不管20日到底是星期几，则只能使用如下写法： 13 13 15 20 * ?, 其中最后一位只能用？，而不能使用*，如果使用*表示不管星期几都会触发，实际上并不是这样。
（3）-：表示范围。例如在Minutes域使用5-20，表示从5分到20分钟每分钟触发一次
（4）/：表示起始时间开始触发，然后每隔固定时间触发一次。例如在Minutes域使用5/20,则意味着5分钟触发一次，而25，45等分别触发一次.
（5）,：表示列出枚举值。例如：在Minutes域使用5,20，则意味着在5和20分每分钟触发一次。
（6）L：表示最后，只能出现在DayofWeek和DayofMonth域。如果在DayofWeek域使用5L,意味着在最后的一个星期四触发。
（7）W:表示有效工作日(周一到周五),只能出现在DayofMonth域，系统将在离指定日期的最近的有效工作日触发事件。例如：在 DayofMonth使用5W，如果5日是星期六，则将在最近的工作日：星期五，即4日触发。如果5日是星期天，则在6日(周一)触发；如果5日在星期一到星期五中的一天，则就在5日触发。另外一点，W的最近寻找不会跨过月份 。
（8）LW:这两个字符可以连用，表示在某个月最后一个工作日，即最后一个星期五。
（9）#:用于确定每个月第几个星期几，只能出现在DayofMonth域。例如在4#2，表示某月的第二个星期三。












==================quartz=====================
==================quartz=====================
==================quartz=====================
==================quartz=====================

implements Job {

}
定义任务类，任务触发时执行

固定格式：=====

 JobDetail jobDetail = JobBuilder.newJob(QuartJob.class).build();
        //触发器
        //SimpleScheduleBuilder.repeatSecondlyForever()触发时间相当于@Scheduled(cron=);
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?")).build();
//        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever()).build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();



springboot中配置
启动类添加
@EnableScheduling
配置类

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(QuartJob.class);
        return jobDetailFactoryBean;
    }

    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        simpleTriggerFactoryBean.setRepeatInterval(1000);//毫秒数
        simpleTriggerFactoryBean.setRepeatCount(5);//重复次数
        return simpleTriggerFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setCronExpression("*/2 * * * * ?");
        return cronTriggerFactoryBean;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
        return schedulerFactoryBean;
    }

//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean){
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
//        return schedulerFactoryBean;
//    }
}


AdaptableJobFactory重写createJobInstance方法
AutowireCapableBeanFactory
作用：实现bean对象添加到IOC容器中，并自动注入依赖属性，将job中需要注入的属性，托管给spring容器注入】
