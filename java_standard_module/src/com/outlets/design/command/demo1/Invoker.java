package com.outlets.design.command.demo1;

/**
 * @description 执行人
 * @author: huangyeqin
 * @create : 2021/4/19  8:54
 */
public class Invoker {

  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void action() {
    command.execute();
  }
}
