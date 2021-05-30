/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ToyotaModelImpl
 * Author:   hyqin
 * Date:     2019-08-11 13:29
 * Description: 丰田车的实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.templateMethod.type01;

/**
 * 〈一句话功能简述〉<br>
 * 〈丰田车的实现类〉
 *
 * @author hyqin
 * @create 2019-08-11
 * @since 1.0.0
 */
public class ToyotaModelImpl extends HummerModel {
    @Override
    protected void start() {
        System.out.println("丰田汽车启动了");
    }

    @Override
    protected void stop() {
        System.out.println("丰田汽车停止了");
    }

    @Override
    protected void alarm() {
        System.out.println("丰田汽车的喇叭");
    }

    @Override
    protected void run() {
        System.out.println("丰田汽车开始跑了");
    }

    @Override
    protected void engineBoom() {
        System.out.println("丰田的引擎启动了");
    }

  @Override
  protected boolean isAlarm() {
    return true;
  }
}
