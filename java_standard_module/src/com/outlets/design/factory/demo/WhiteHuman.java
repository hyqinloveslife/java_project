package com.outlets.design.factory.demo;

import com.outlets.example.demo01.Human;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:21
 */
public class WhiteHuman implements IHuman {

  @Override
  public void say() {
    System.out.println("我是白种人，来自欧洲");
  }
}
