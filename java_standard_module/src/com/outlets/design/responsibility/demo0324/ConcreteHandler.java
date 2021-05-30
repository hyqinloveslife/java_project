package com.outlets.design.responsibility.demo0324;

import java.util.HashMap;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/3/24  13:38
 */
public class ConcreteHandler extends IHandler {

  public ConcreteHandler(IUserAuthStrategy strategy) {
    super.strategy = strategy;
  }

  @Override
  public void handleRequest() {
    if (successor != null) {
      System.out.println("放过请求");
      getSuccessor().handleRequest();
    } else {
      HashMap user = strategy.getUser(new HashMap());
      System.out.println(user);
      System.out.println("处理请求");
    }
  }
}
