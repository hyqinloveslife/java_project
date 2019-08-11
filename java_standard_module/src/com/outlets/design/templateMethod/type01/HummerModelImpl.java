/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HummerModelImpl
 * Author:   hyqin
 * Date:     2019-08-11 13:29
 * Description: 悍马模型实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.templateMethod.type01;

/**
 * 〈一句话功能简述〉<br>
 * 〈悍马模型实现类〉
 *
 * @author hyqin
 * @create 2019-08-11
 * @since 1.0.0
 */
public class HummerModelImpl extends HummerModel {
    @Override
    protected void start() {
        System.out.println("悍马汽车启动了");
    }

    @Override
    protected void stop() {
        System.out.println("悍马汽车停止了");
    }

    @Override
    protected void alarm() {
        System.out.println("悍马汽车的喇叭");
    }

    @Override
    protected void run() {
        System.out.println("悍马汽车开动了");
    }

    @Override
    protected void engineBoom() {
        System.out.println("悍马汽车的引擎");
    }

    @Override
    protected boolean isAlarm() {
        return false;
    }
}
