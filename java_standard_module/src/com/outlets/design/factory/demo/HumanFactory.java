package com.outlets.design.factory.demo;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:18
 */
public class HumanFactory extends AbsHumanFactory<IHuman> {

  @Override
  public <T extends IHuman> T createHuman(Class<T> tClass) {
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
