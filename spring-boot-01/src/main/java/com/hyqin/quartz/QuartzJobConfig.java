/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuartzJobConfig
 * Author:   hyqin
 * Date:     2019-09-30 15:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.quartz;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author hyqin
 * @create 2019-09-30
 * @since 1.0.0
 */
@Configuration
public class QuartzJobConfig {
    /**
     * 方法调用任务明细工厂Bean
     */

    @Bean(name = "myFirstExerciseJobBean")
    public JobDetailFactoryBean myFirstExerciseJobBean() {
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setName("general-myFirstExerciseJob"); // 任务的名字
        jobDetail.setGroup("general"); // 任务的分组
        jobDetail.setJobClass(MyFirstExecuteJob.class);
        jobDetail.setDurability(true);
        return jobDetail;
    }

    @Bean(name = "myFirstExerciseJobTrigger")
    public CronTriggerFactoryBean myFirstExerciseJobTrigger(@Qualifier("myFirstExerciseJobBean") JobDetailFactoryBean myFirstExerciseJobBean) {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(myFirstExerciseJobBean.getObject());
        tigger.setCronExpression("0/10 * * * * ?"); // 什么是否触发，Spring Scheduler Cron表达式
        tigger.setName("general-myFirstExerciseJobTrigger");
        return tigger;
    }
}
