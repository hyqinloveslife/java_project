package com.outlets.design.factory.demo;

import com.outlets.example.demo01.Human;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:15 我是否可以把这个工厂，改造成任何工厂呢？
 */
public abstract class AbsHumanFactory<E> {

  public abstract <T extends E> T createHuman(Class<T> tClass);
}
