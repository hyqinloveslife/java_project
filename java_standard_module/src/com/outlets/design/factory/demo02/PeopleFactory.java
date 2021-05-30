package com.outlets.design.factory.demo02;

import com.outlets.design.factory.demo.IHuman;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:39
 */
public class PeopleFactory extends AbstractFactory<IHuman> {

  @Override
  public <T extends IHuman> T doProduct(Class<T> tClass) {
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
