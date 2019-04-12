/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CallableAndFuture
 * Author:   hyqin
 * Date:     2019-04-11 14:27
 * Description: 测试callable和thread中方法的区别
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试callable和thread中方法的区别〉
 *
 * @author hyqin
 * @create 2019-04-11
 * @since 1.0.0
 */
public class CallableAndFuture {
    public static class MyCallable implements Callable<String> {
        private int flag = 0;

        public MyCallable(int flag) {
            this.flag = flag;
        }

        @Override
        public String call() throws Exception {
            if (this.flag == 0) {
                return "flag = 0";
            }
            if (this.flag == 1) {
                while (true) {
                    System.out.println("looping.");
                    Thread.sleep(1000);
                }
            } else {
                throw new Exception("bad flag value!");
            }

        }
    }


    public static void main(String[] args) {
        //定义三个callable类型的任务
        MyCallable call1 = new MyCallable(0);
        MyCallable call2 = new MyCallable(1);
        MyCallable call3 = new MyCallable(2);

        System.out.println("获取系统处理器个数 : " + Runtime.getRuntime().availableProcessors());

        //创建一个执行任务的服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        try {
            Future f1 = service.submit(call1);
            System.out.println("call1  " + f1.get());

            Future f2 = service.submit(call2);
            Thread.sleep(5000);
            System.out.println("call2  " + f2.cancel(true));


            Future f3 = service.submit(call3);
            System.out.println("call3  " + f3.get());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
