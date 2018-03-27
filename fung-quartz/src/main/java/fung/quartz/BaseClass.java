package fung.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1))
                .build();

        JobDetail job = JobBuilder.newJob(HelloQuartzJob.class)
                .withDescription("this is a job")
                .withIdentity("job1", "group1")
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        TimeUnit.SECONDS.sleep(60);

        scheduler.shutdown(true);

    }

}
