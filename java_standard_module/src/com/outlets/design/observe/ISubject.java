package com.outlets.design.observe;

import java.util.List;

/**
 * @description 消息订阅主题
 * @author: hyqin
 * @create : 2020/6/18
 */
public interface ISubject {

  /**
   * 观察者对消息主题进行订阅
   */
  void register(IObserve observer);

  /**
   * 观察者对消息取消订阅
   */
  void removeOut(IObserve observer);

  /**
   * 消息推送
   */
  void notifyObserver();

}
