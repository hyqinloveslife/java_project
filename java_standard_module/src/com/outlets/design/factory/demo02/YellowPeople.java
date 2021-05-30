package com.outlets.design.factory.demo02;

import com.outlets.design.factory.demo.IHuman;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:20
 */
public class YellowPeople implements IHuman {

  @Override
  public void say() {
    System.out.println("我是黄种人，来自亚洲");
  }
}
