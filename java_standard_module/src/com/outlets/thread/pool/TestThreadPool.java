/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestThreadPool
 * Author:   hyqin
 * Date:     2019-04-11 14:21
 * Description: 简单的测试一下线程池
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.thread.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 〈一句话功能简述〉<br>
 * 〈简单的测试一下线程池〉
 *
 * @author hyqin
 * @create 2019-04-11
 * @since 1.0.0
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("这是一个线程池");


    }
}
