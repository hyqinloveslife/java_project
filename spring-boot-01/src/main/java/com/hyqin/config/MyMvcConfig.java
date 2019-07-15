/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyMvcConfig
 * Author:   hyqin
 * Date:     2019-07-15 22:33
 * Description: 自定义配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自定义配置〉
 *
 * @author hyqin
 * @create 2019-07-15
 * @since 1.0.0
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("logo");
                registry.addViewController("/index.html").setViewName("logo");
            }
        };
        return adapter;
    }

}
