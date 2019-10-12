/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SpringBootStartApplication
 * Author:   hyqin
 * Date:     2019-10-01 23:31
 * Description: 一个新的启动类，可以将项目打成war包
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈一个新的启动类，可以将项目打成war包〉
 *
 * @author hyqin
 * @create 2019-10-01
 * @since 1.0.0
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HelloWorldMainApplication.class);
    }
}
