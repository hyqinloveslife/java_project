package com.outlets.design.observe;

/**
 * @description 观察者
 * @author: hyqin
 * @create : 2020/6/18
 */
public interface IObserve {

  /**
   * 观察者接收消息
   */
  void accept(String message);

}
