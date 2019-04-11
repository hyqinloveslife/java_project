/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MainThreadTest
 * Author:   hyqin
 * Date:     2019-04-11 9:46
 * Description: 测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.thread.day01;

import java.util.Vector;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试类〉
 * 在实现多线程的过程中，本来想写一个简单的例子，就是多个线程操作一个list，在取得数据后立马删除数据，
 * 可是写了很久都无法实现，从网上找的例子也无法实现。后来把list换成vector以后，测试了大概十多次，
 * 数据都是对的。
 * 可能原因是vector是线程安全的。但如果是这样，就失去了这个例子的意义。
 *
 * @author hyqin
 * @create 2019-04-11
 * @since 1.0.0
 */
public class MainThreadTest {
    public final static Vector<Integer> numsList = new Vector<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<100;i++){
            numsList.add(i);
        }

        String abs = "x";
        String abs2 = "s";

        Object lockObject = new Object();

        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread(abs2,lockObject);

        Thread thread1 = new Thread(t1);
        thread1.setName("司马懿");
        thread1.start();

        Thread thread2 = new Thread(t1);
        thread2.setName("诸葛亮");
        thread2.start();

//        t2.start();
//        t1.start();


    }


}
