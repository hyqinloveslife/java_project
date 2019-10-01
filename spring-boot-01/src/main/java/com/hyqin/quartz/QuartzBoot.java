/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuartzBoot
 * Author:   hyqin
 * Date:     2019-09-30 15:28
 * Description: 测试quartz
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试quartz〉
 *
 * @author hyqin
 * @create 2019-09-30
 * @since 1.0.0
 */
public class QuartzBoot {
    private static Logger logger = LoggerFactory.getLogger(QuartzBoot.class);

    public static void main(String[] args) {
        try {
            //获取调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            //开启调度器
            scheduler.start();

            //注册一个实例任务和触发器
            registerJobAndTrigger(scheduler);


        }catch (Exception e){
            logger.error("获取调度器异常:"+e.getMessage());
        }
    }

    //注册一个实例任务
    public static void registerJobAndTrigger(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MySimpleJob.class)
                                .withIdentity("mySimpleJob","simpleGroup")
                                .build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger","simpleGroup")
                                                    .startNow()
                                                    .withSchedule(simpleSchedule().withIntervalInSeconds(10)
                                                            .repeatForever())
                                                    .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    public static class MySimpleJob implements Job{

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            logger.info("=================真的执行了吗？======================");
        }
    }

}
