package com.outlets.design.decorator.demo1;

/**
 * @description 正品专卖店类
 * @author: huangyeqin
 * @create : 2021/5/4  23:40
 */
public class GenuineStores implements TopSports {

  @Override
  public void sell() {
    System.out.println("正品专卖店");
  }
}
