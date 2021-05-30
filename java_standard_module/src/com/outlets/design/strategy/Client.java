package com.outlets.design.strategy;

/**
 * @description 客户端
 * @author: huangyeqin
 * @create : 2020/12/16  10:09
 */
public class Client {

  public static void main(String[] args) {
    String name = "zhaoyun";
    StrategyContext context = new StrategyContext(StrategyEnum.getStrategyByName(name));
    context.handler();
  }
}
