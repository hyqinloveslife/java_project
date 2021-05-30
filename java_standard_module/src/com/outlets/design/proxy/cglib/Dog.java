package com.outlets.design.proxy.cglib;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/17  12:14
 */
public class Dog {

  public final void run(String name) {
    System.out.println("狗 " + name + "  -- run ");
  }

  public void eat() {
    System.out.println("  狗 --- 吃");
  }

}
