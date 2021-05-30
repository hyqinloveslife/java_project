package com.outlets.design.responsibility.demo0324;

/**
 * @description 责任链
 * @author: huangyeqin
 * @create : 2021/3/24  12:05
 */
public abstract class IHandler {

  // 下一个责任对象
  protected IHandler successor;

  protected IUserAuthStrategy strategy;

  public abstract void handleRequest();

  public IHandler getSuccessor() {
    return successor;
  }

  public void setSuccessor(IHandler successor) {
    this.successor = successor;
  }
}
