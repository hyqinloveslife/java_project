package com.outlets.design.command.demo1;

/**
 * @description 客户端类
 * @author: huangyeqin
 * @create : 2021/4/19  9:09
 */
public class Client {

  public static void main(String[] args) {
    // 定义出一个执行命令的人
    Invoker invoker = new Invoker();

    // 定义一个命令
    Command command = new CodeDeleteCommand();

    invoker.setCommand(command);

    invoker.action();

  }
}
