package com.outlets.design.factory.type02;

import java.io.Serializable;

/**
 * @description 工厂
 * @author: huangyeqin
 * @create : 2021/3/6  23:32
 */
public class ClassFactory {

  public static Class<? extends Serializable> getBean(Class clazz) throws ClassNotFoundException {

    Class<?> aClass = Class.forName(clazz.getName());

    return (Class<? extends Serializable>) aClass;
  }
}
