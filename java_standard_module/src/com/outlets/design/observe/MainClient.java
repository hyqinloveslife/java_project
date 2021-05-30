package com.outlets.design.observe;

/**
 * @description
 * @author: hyqin
 * @create : 2020/6/18
 */
public class MainClient {

  public static void main(String[] args) {
    WechatService server = new WechatService();

    IObserve zhangsan = new WechatUser("张三");
    IObserve lisi = new WechatUser("李四");
    IObserve wangwu = new WechatUser("王五");

    server.register(zhangsan);
    server.register(lisi);
    server.register(wangwu);

    server.sendMessage("PHP是世界上最好的语言");


  }
}
