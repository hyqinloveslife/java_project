package com.outlets.design.factory.demo02;

import com.outlets.design.factory.demo.IHuman;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:19
 */
public class BlackPeople implements IHuman {

  @Override
  public void say() {
    System.out.println("我是黑种人，来自非洲");
  }
}
