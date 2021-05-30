package com.outlets.design.decorator.demo1;

/**
 * @description 卖假货的李宁专卖店，但偶尔也有真货
 * @author: huangyeqin
 * @create : 2021/4/16  22:15
 */
public class ASellSports implements TopSports {

  TopSports topSports;

  public ASellSports(TopSports topSports) {
    this.topSports = topSports;
  }


  @Override
  public void sell() {
    topSports.sell();
  }
}
