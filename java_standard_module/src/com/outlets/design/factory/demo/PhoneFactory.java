package com.outlets.design.factory.demo;

import com.outlets.design.factory.type01.IProduct;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:27 手机工厂，也可以集成初始的抽象工厂
 */
public class PhoneFactory extends AbsHumanFactory<IProduct> {

  @Override
  public <T extends IProduct> T createHuman(Class<T> tClass) {
    try {
      return (T) Class.forName(tClass.getName()).newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }
}
