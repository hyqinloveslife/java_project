package com.outlets.design.decorator.demo1;

/**
 * @description 特步专卖店-子类，实现top专卖店
 * @author: huangyeqin
 * @create : 2021/4/16  22:13
 */
public class XtepSports extends ASellSports {

  public XtepSports(TopSports topSports) {
    super(topSports);
  }

  @Override
  public void sell() {
    System.out.println("这里是特步专卖店...");
    super.sell();
  }
}
