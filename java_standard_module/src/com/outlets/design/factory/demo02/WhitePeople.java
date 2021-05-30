package com.outlets.design.factory.demo02;

import com.outlets.design.factory.demo.IHuman;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:21
 */
public class WhitePeople implements IHuman {

  @Override
  public void say() {
    System.out.println("我是白种人，来自欧洲");
  }
}
