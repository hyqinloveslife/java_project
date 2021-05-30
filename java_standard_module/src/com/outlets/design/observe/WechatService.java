package com.outlets.design.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 定义具体的消息主题实现类
 * @author: hyqin
 * @create : 2020/6/18
 */
public class WechatService implements ISubject {

  List<IObserve> observers = new ArrayList<>();

  String message;

  @Override
  public void register(IObserve observer) {
    observers.add(observer);
  }

  @Override
  public void removeOut(IObserve observer) {
    if (!observers.isEmpty()) {
      observers.remove(observer);
    }
  }

  @Override
  public void notifyObserver() {
    for (IObserve o : observers) {
      o.accept(message);
    }
  }

  public void sendMessage(String message) {
    this.message = message;
    System.out.println("微信消息订阅了...");
    notifyObserver();
  }
}
