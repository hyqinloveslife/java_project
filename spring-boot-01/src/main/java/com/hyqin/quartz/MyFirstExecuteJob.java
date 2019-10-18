/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyFirstExecuteJob
 * Author:   hyqin
 * Date:     2019-09-30 15:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.quartz;

import com.hyqin.service.QuartzService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hyqin
 * @create 2019-09-30
 * @since 1.0.0
 */
@Component
@EnableScheduling
public class MyFirstExecuteJob implements Job {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Autowired
    private QuartzService quartzService;

    private void myJobBusinessMethod(){
        int res = quartzService.addQuarzts();
//        this.logger.info("==============被执行了吗？ "+res+"  =================");

    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        this.myJobBusinessMethod();
    }
}
