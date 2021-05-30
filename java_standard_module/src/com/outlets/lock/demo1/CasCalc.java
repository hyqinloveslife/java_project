package com.outlets.lock.demo1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/26  10:48
 */
public class CasCalc {

  public static AtomicInteger count = new AtomicInteger(0);

  public static void add() {
    count.incrementAndGet();
  }
}
