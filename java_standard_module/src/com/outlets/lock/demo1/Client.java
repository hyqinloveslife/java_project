package com.outlets.lock.demo1;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/26  10:46
 */
public class Client {

  public static void main(String[] args) {
    System.out.println("计算之前：" + CountPlus.count);
    for (int i = 0; i < 10; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          CountPlus.add();
        }
      }).start();
    }
    System.out.println("计算之后：" + CountPlus.count);

    System.out.println("使用cas算法");
    System.out.println("cas算法计算之前：" + CasCalc.count);
    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        CasCalc.add();
      }).start();
    }
    System.out.println("cas算法计算之后：" + CasCalc.count);
  }
}
