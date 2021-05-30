package com.outlets.thread.learn02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @description 测试一下多线程和线程池的执行时间
 * @author: huangyeqin
 * @create : 2020/12/17  22:01
 */
public class TestThread {

  public static void main(String[] args) throws InterruptedException {
    Long start = System.currentTimeMillis();
    List<Integer> list = new ArrayList<>();
    final Random random = new Random();
    for (int i = 0; i < 100000; i++) {
      Thread thread = new Thread() {
        @Override
        public void run() {
          list.add(random.nextInt());
        }
      };
      thread.start();
      thread.join();
    }
    System.out.println("运行时间:" + (System.currentTimeMillis() - start));
    System.out.println("数组大小:" + list.size());
  }
}
