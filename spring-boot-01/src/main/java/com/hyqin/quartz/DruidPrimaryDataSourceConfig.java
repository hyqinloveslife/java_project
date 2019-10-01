/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DruidPrimaryDataSourceConfig
 * Author:   hyqin
 * Date:     2019-09-30 16:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.quartz;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hyqin
 * @create 2019-09-30
 * @since 1.0.0
 */
@Configuration
public class DruidPrimaryDataSourceConfig {

    @Autowired
    private DruidPrimaryDataSourceConfigProperties properties;

    @Bean
    public DataSource primaryDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        /*基础配置*/
        dataSource.setUrl(this.properties.getUrl());
        dataSource.setUsername(this.properties.getUsername());
        dataSource.setPassword(this.properties.getPassword());
        dataSource.setDriverClassName(this.properties.getDriverClassName());

        /*其他配置*/
        dataSource.setInitialSize(this.properties.getInitialSize());
        dataSource.setMinIdle(this.properties.getMinIdle());
        dataSource.setMaxActive(this.properties.getMaxActive());
        dataSource.setMaxWait(this.properties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(this.properties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(this.properties.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(this.properties.getValidationQuery());
        dataSource.setTestWhileIdle(this.properties.getTestWhileIdle());
        dataSource.setTestOnBorrow(this.properties.getTestOnBorrow());
        dataSource.setTestOnReturn(this.properties.getTestOnReturn());
        return dataSource;
    }
}
