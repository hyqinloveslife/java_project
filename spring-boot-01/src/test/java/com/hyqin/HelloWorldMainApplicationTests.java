/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HelloWorldMainApplication
 * Author:   hyqin
 * Date:     2019-07-05 10:33
 * Description: 测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin;

import com.hyqin.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试类〉单元测试
 *
 * @author hyqin
 * @create 2019-07-05
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldMainApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Person person;

    @Test
    public void test1(){
        System.out.println(person);
    }

    @Test
    public void testLog(){
        logger.trace("这是一个trace日志");
        logger.debug("这是一个debug日志");
        logger.warn("这是一个warn日志");
        logger.info("这是一个info日志");
        logger.error("这是一个error日志");
    }


}
