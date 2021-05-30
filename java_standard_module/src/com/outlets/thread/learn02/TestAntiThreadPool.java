package com.outlets.thread.learn02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/**
 * @description 手工创建线程池
 * @author: huangyeqin
 * @create : 2020/12/18  14:22
 */
public class TestAntiThreadPool {

  public static void main(String[] args) throws InterruptedException {
    Long start = System.currentTimeMillis();
    List<Integer> list = new ArrayList<>();
    final Random random = new Random();
    ExecutorService service = new ThreadPoolExecutor(6, 30, 0L, TimeUnit.MILLISECONDS,
        new LinkedBlockingDeque<>());
    for (int i = 0; i < 10000; i++) {
      try {
        service.execute(() -> {
          list.add(random.nextInt());
          System.out.println(Thread.currentThread().getName());
        });
      } catch (RejectedExecutionException e) {
        System.out.println("第" + (i + 1) + "行报错了，但是继续执行");
      }
    }
    service.shutdown();
    service.awaitTermination(1, TimeUnit.DAYS);
    System.out.println("运行时间:" + (System.currentTimeMillis() - start));
    System.out.println("数组大小:" + list.size());
  }
}
