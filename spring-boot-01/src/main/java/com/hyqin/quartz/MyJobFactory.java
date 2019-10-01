/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyJobFactory
 * Author:   hyqin
 * Date:     2019-10-01 22:40
 * Description: 解决一个问题，因为在定时任务中，无法使用auto wired来自动配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈解决一个问题，因为在定时任务中，无法使用auto wired来自动配置〉
 *
 * @author hyqin
 * @create 2019-10-01
 * @since 1.0.0
 */
@Component
public class MyJobFactory extends SpringBeanJobFactory {

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object instance =super.createJobInstance(bundle);
        beanFactory.autowireBean(instance);
        return instance;
    }
}
