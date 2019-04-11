/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MultiThread
 * Author:   hyqin
 * Date:     2019-04-11 11:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.thread.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author hyqin
 * @create 2019-04-11
 * @since 1.0.0
 */
public class MultiThread {
    // 用Collections.synchronizedList让list线程安全
    public final static List<Long> list = Collections.synchronizedList(new ArrayList<Long>());

    public static void main(String[] args) {
// 为List添加100个数据
        for (int i = 1; i <= 100; i++) {
            list.add(Long.valueOf(i));
        }

        MyRunnable myThread = new MyRunnable();
// 开启四个线程处理list数据
        Thread t1 = new Thread(myThread);
        t1.setName("线程1");
        t1.start();

        Thread t2 = new Thread(myThread);
        t2.setName("线程2");
        t2.start();

        Thread t3 = new Thread(myThread);
        t3.setName("线程3");
        t3.start();

        Thread t4 = new Thread(myThread);
        t4.setName("线程4");
        t4.start();
    }
}
