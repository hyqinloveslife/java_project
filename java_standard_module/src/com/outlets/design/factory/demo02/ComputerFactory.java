package com.outlets.design.factory.demo02;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:37
 */
public class ComputerFactory extends AbstractFactory<IComputer> {

  @Override
  public <T extends IComputer> T doProduct(Class<T> tClass) {
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
