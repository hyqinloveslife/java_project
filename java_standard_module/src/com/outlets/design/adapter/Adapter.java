package com.outlets.design.adapter;

/**
 * 类适配器模式
 *
 * @description
 * @author: huangyeqin
 * @create : 2020/11/26  10:31
 */
public class Adapter extends IAdaptee implements ITarget {

  @Override
  public void request() {
    specificRequest();
  }
}
