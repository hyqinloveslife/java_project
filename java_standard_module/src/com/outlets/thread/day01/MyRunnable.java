/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyRunnable
 * Author:   hyqin
 * Date:     2019-04-11 11:39
 * Description: 实现runnable接口的线程类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.thread.day01;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈实现runnable接口的线程类〉
 *
 * @author hyqin
 * @create 2019-04-11
 * @since 1.0.0
 */
public class MyRunnable implements Runnable {
    private final List<Long> list = MultiThread.list;

    @Override
    public void run() {
        for (int i = 0; i < list.size(); ) {
// 同步list，打印数据并删除该数据
            synchronized (list) {
                try {
//当前线程睡眠，让其它线程获得执行机会
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + list.get(i));
                list.remove(i);
            }
        }
    }
}
