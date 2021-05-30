package com.outlets.design.decorator.demo1;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/5/4  23:46
 */
public class AdidasSports extends ASellSports {

  public AdidasSports(TopSports topSports) {
    super(topSports);
  }

  @Override
  public void sell() {
    System.out.println("这里是阿迪达斯专卖店");
    super.sell();
  }
}
