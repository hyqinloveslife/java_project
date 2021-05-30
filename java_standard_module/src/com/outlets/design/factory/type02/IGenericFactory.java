package com.outlets.design.factory.type02;

import java.io.Serializable;
import java.util.List;

/**
 * @description 一个抽象工厂
 * @author: huangyeqin
 * @create : 2021/3/6  22:10
 */
public interface IGenericFactory {

//  IGenericProduct getBean(Class<? extends Serializable> clazz);

  List<Apple> selectList(String name);

}
