package com.heiyu.iot.sdk.configure;

import com.heiyu.iot.sdk.entity.configmap.ConfigMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.Thread.sleep;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * //TODO
 * @author : William—Wang
 * @version : 1.0
 * @date : 0:17 2020/1/29
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuartzConfigTest {

    @Qualifier("schedulerFactoryBean")
    @Autowired
    private Scheduler scheduler ;


    @Test
    public void scheduleTest() throws SchedulerException, InterruptedException {
        System.out.println("233");
        JobDataMap jobDataMap =  new JobDataMap();
        jobDataMap.put("sensorMap",ConfigMap.getConfigMap());
        JobDetail detail = newJob(FackJob.class)
                .withIdentity("fackjob")
                .usingJobData(jobDataMap)
                .build();
        Trigger cronTrigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .withRepeatCount(10))
                .build();
        scheduler.scheduleJob(detail,cronTrigger);
        sleep(1000*20);
    }

}
