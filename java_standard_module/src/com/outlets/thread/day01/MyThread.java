/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyThread
 * Author:   hyqin
 * Date:     2019-04-11 9:44
 * Description: 一个类继承thread类，开启一个线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.thread.day01;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈一个类继承thread类，开启一个线程〉
 *
 * @author hyqin
 * @create 2019-04-11
 * @since 1.0.0
 */
public class MyThread implements Runnable {
//    private String commandName;
    private final Vector<Integer> intList = MainThreadTest.numsList;
//    private Object lockObject;
//    private static Set<Integer> set= new HashSet<>();


    @Override
    public void run() {
       for (int i=0;i<intList.size();){
           synchronized (intList){
               if (intList.size()==0){
                   break;
               }
               System.out.println(Thread.currentThread().getName()+"  ===>   "+intList.remove(i));
               //intList.remove(i);
           }
       }
    }

}
