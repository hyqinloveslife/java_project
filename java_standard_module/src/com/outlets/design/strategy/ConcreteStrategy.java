package com.outlets.design.strategy;

/**
 * @description 具体策略1
 * @author: huangyeqin
 * @create : 2020/12/16  10:07
 */
public class ConcreteStrategy implements IStrategy {

  @Override
  public void execute() {
    System.out.println("具体策略1");
  }
}
