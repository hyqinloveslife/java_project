package com.outlets.design.proxy;

/**
 * 代理类和被代理类，在编译期间就已经确定下来了
 *
 * @description 静态代理类
 * @author: huangyeqin
 * @create : 2020/11/19  16:03
 */
public class StaticProxy {

  public static void main(String[] args) {
    ClothFactory clothFactory = new ProxyClothFactory(new LININGClothFactory());
    clothFactory.productCloth();
  }

}

// 静态代理类
class ProxyClothFactory implements ClothFactory {

  private ClothFactory factory;

  public ProxyClothFactory(ClothFactory factory) {
    this.factory = factory;
  }

  @Override
  public void productCloth() {
    System.out.println("我是李宁的代理商");
    factory.productCloth();
    System.out.println("广告：承接任何商家衣服的代理");
  }
}

// 被代理类
class LININGClothFactory implements ClothFactory {

  @Override
  public void productCloth() {
    System.out.println("生产李宁的衣服");
  }
}

// 衣服工厂，可以生产衣服
interface ClothFactory {

  void productCloth();
}