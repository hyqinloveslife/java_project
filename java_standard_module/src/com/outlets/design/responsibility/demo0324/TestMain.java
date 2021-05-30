package com.outlets.design.responsibility.demo0324;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/3/24  13:39
 */
public class TestMain {

  public static void main(String[] args) {
    IHandler handler = new ConcreteHandler(new CorePortalStragety());
    IHandler handler2 = new ConcreteHandler(new MedPortalStrategy());

    handler.setSuccessor(handler2);
    handler.handleRequest();
  }
}
