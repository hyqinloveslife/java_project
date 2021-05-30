package com.outlets.design.adapter;

/**
 * 对象适配器，就是将继承改成聚合
 *
 * @description 对象适配器
 * @author: huangyeqin
 * @create : 2020/11/26  11:00
 */
public class Adapter4Object implements ITarget {

  private IAdaptee adaptee;

  public Adapter4Object(IAdaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public void request() {
    adaptee.specificRequest();
  }
}
