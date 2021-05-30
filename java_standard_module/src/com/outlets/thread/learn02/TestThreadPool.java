package com.outlets.thread.learn02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description 测试线程池的执行时间
 * @author: huangyeqin
 * @create : 2020/12/17  22:04
 */
public class TestThreadPool {

  public static void main(String[] args) throws InterruptedException {
    Long start = System.currentTimeMillis();
    List<Integer> list = new ArrayList<>();
    final Random random = new Random();
    ExecutorService service = Executors.newSingleThreadExecutor();
    for (int i = 0; i < 100000; i++) {
      service.execute(() -> list.add(random.nextInt()));
    }
    service.shutdown();
    service.awaitTermination(1, TimeUnit.DAYS);
    System.out.println("运行时间:" + (System.currentTimeMillis() - start));
    System.out.println("数组大小:" + list.size());
  }
}
