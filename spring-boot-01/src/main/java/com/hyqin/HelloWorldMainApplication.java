/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HelloWorldMainApplication
 * Author:   hyqin
 * Date:     2019-07-02 22:46
 * Description: 启动spring boot的主程序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈一句话功能简述〉<br> 
 * 〈启动spring boot的主程序〉
 *
 * @author hyqin
 * @create 2019-07-02
 * @since 1.0.0
 */

/**
 * @SpringBootApplication 来标志这是一个主程序,说明这是一个spring boot应用
 */
@MapperScan(value = {"com.hyqin.mapper"})
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        /**
         * spring应用启动起来
         * 需要启动的时候直接运行main方法，然后在浏览器中输入localhost:8080就可以了
         */
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
