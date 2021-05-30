package com.outlets.design.strategy;

import java.rmi.Naming;
import javax.print.attribute.standard.MediaSize.NA;

/**
 * @description 策略模式枚举类
 * @author: huangyeqin
 * @create : 2020/12/16  10:19
 */
public enum StrategyEnum {
  ZHAOYUN_STRATEGY("ConcreteStrategy", new ConcreteStrategy()),
  GUANYU_STRATEGY("Concrete2Strategy", new Concrete2Strategy());

  private IStrategy strategy;
  private String name;

  StrategyEnum(String name, IStrategy strategy) {
    this.name = name;
    this.strategy = strategy;
  }

  public IStrategy getStrategy() {
    return strategy;
  }

  public void setStrategy(IStrategy strategy) {
    this.strategy = strategy;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * 根据name获取strategy的值
   *
   * @Desc :
   * @Author : huangyeqin
   * @Date : 2020/12/16 10:26
   * @Param : code
   * @Result : com.outlets.design.strategy.IStrategy
   */
  public static IStrategy getStrategyByName(String code) {
    for (StrategyEnum platformFree : StrategyEnum.values()) {
      if (code.equals(platformFree.getName())) {
        return platformFree.getStrategy();
      }
    }
    return null;
  }
}
