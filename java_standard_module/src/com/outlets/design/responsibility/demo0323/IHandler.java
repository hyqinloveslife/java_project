package com.outlets.design.responsibility.demo0323;

import com.outlets.design.responsibility.demo0324.IUserAuthStrategy;
import java.util.HashMap;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/3/24  14:05
 */
public abstract class IHandler {

  // 能处理的级别
  private int level = 0;

  // 责任链传递
  private IHandler nextHandler;

  // 每个类都要说明自己能处理哪些请求
  public IHandler(int level) {
    this.level = level;
  }

  public final void handleMessage(IUserAuthStrategy strategy) {
    if (strategy.getType() == this.level) {
      this.response(strategy);
    } else {
      if (this.nextHandler != null) {
        // 如果存在后续环节，就把请求往后传递
        this.nextHandler.handleMessage(strategy);
      } else {
        System.out.println("没有后续环节");
      }
    }
  }

  public void setNextHandler(IHandler nextHandler) {
    this.nextHandler = nextHandler;
  }

  public abstract HashMap response(IUserAuthStrategy strategy);

}
