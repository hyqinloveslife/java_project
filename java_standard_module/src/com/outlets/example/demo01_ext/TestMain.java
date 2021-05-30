package com.outlets.example.demo01_ext;

/**
 * @description
 * @author: hyqin
 * @create : 2020/6/8
 */
public class TestMain {

  /**
   * 想测试一下每一个关键字的权限，突然有一个想法； 在一个普通类里面定义一个default或者friendly或者protected方法，这种是无法跨包访问的。
   * 但在另一个包(demo_ext)下面，有一个类去继承这个父类，但是不重写该方法，那么在(demo_ext)下，是否能访问到父类中的方法呢？
   * 答案是不能的，因为Java虚拟机还不至于有这么个漏洞
   */

  public static void main(String[] args) {
    Man aMan = new Man();
    aMan.say();
  }

}
