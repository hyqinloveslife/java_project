package com.outlets.design.observe;

/**
 * @description 微信用户，订阅微信公众号消息
 * @author: hyqin
 * @create : 2020/6/18
 */
public class WechatUser implements IObserve {

  private String name;

  public WechatUser(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void accept(String message) {
    System.out.printf("%s 收到消息 %s \n", name, message);
  }
}
