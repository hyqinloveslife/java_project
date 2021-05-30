package com.outlets.design.strategy;

/**
 * @description 上下文
 * @author: huangyeqin
 * @create : 2020/12/16  10:08
 */
public class StrategyContext {

  private IStrategy strategy;

  public StrategyContext(IStrategy strategy) {
    this.strategy = strategy;
  }

  public void handler() {
    strategy.execute();
  }
}
