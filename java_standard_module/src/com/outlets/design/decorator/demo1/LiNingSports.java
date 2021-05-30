package com.outlets.design.decorator.demo1;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/16  22:14
 */
public class LiNingSports extends ASellSports {

  public LiNingSports(TopSports topSports) {
    super(topSports);
  }

  @Override
  public void sell() {
    System.out.println("这里是李宁专卖店");
    super.sell();
  }
}
