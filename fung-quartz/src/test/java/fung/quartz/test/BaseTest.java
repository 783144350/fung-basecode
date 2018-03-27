package fung.quartz.test;

import org.junit.Test;

public class BaseTest {

    @Test
    public void testHello() {
        System.out.println("Hello Quartz");
    }

    //在Junit框架中Quartz似乎失效了

//    @Test
//    public void testQuartz() throws SchedulerException, InterruptedException {
//        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("trigger1", "group1")
//                .startNow()
//                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1))
//                .build();
//
//        JobDetail job = JobBuilder.newJob(HelloQuartzJob.class)
//                .withDescription("this is a job")
//                .withIdentity("job1", "group1")
//                .build();
//
//        scheduler.scheduleJob(job, trigger);
//
//        scheduler.start();
//
//        TimeUnit.SECONDS.sleep(60);
//
//        scheduler.shutdown(true);
//
//    }
//
//    private class HelloQuartzJob implements Job {
//
//        @Override
//        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//            System.out.println("Hello Quartz");
//        }
//    }

}
