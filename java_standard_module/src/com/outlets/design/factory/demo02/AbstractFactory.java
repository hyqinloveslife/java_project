package com.outlets.design.factory.demo02;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:32
 */
public abstract class AbstractFactory<E> {

  /**
   * 定义一个抽象工厂，可以生产任何东西，只要任意一个实体工厂继承这个抽象类，并将抽象方法实现 其中，E可以表示成一个接口，一个规范，所有的T 类型都要实现这个E接口
   * spring的工厂方法应该跟这个差不多吧
   *
   * @Desc :
   * @Author : huangyeqin
   * @Date : 2021/4/8 9:33
   * @Param : tClass
   * @Result : T
   */
  public abstract <T extends E> T doProduct(Class<T> tClass);

}
