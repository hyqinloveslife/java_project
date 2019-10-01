/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuartzConfig
 * Author:   hyqin
 * Date:     2019-09-30 16:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.quartz;

import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hyqin
 * @create 2019-09-30
 * @since 1.0.0
 */
@Configuration
public class QuartzConfig {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier(value = "primaryDataSource")
    private DataSource primaryDataSource;

    @Autowired
    private MyJobFactory factory;

    @Bean(name = "shedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean(Trigger ... triggers){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();

        Properties p = new Properties();
        try {
            p.load(this.getClass().getClassLoader().getResourceAsStream("quartz.properties"));
        }catch (Exception e){
            logger.error("没有找到 quartz.properties");
            throw new Error(e.getMessage());
        }
        bean.setQuartzProperties(p);
        bean.setDataSource(this.primaryDataSource);


        bean.setOverwriteExistingJobs(true);
        bean.setStartupDelay(15);
        bean.setTriggers(triggers);
        /*这里是一行关键代码，解决了定时任务中auto wired无法注册的问题*/
        bean.setJobFactory(factory);
        return bean;
    }
}
