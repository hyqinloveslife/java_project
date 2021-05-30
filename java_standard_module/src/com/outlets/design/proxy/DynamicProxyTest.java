package com.outlets.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Comparator;

/**
 * @description 动态代理类
 * @author: huangyeqin
 * @create : 2020/11/19  16:18
 */
public class DynamicProxyTest {

  public static void main(String[] args) {
    Human o = (Human) ProxyFactory.getProxyInstance(new SuperMan());
    System.out.println(o.getBelief());
//    o.eat("牛肉干");
  }

  public static void main(String[] args, String str) {
    System.out.println("这也是一个main方法");
  }
}

interface Human {

  String getBelief();

  void eat(String food);
}

// 被代理类
class SuperMan implements Human {

  @Override
  public String getBelief() {
    return "信仰中国共产党";
  }

  @Override
  public void eat(String food) {
    System.out.println("我喜欢吃" + food);
  }
}

class ProxyFactory {

  //
  public static Object getProxyInstance(Object obj) {
    InvocationHandler handler = new MyInvocationHandler(obj);

    return Proxy
        .newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
  }
}

class MyInvocationHandler implements InvocationHandler {

  private Object object;

  public MyInvocationHandler(Object object) {
    this.object = object;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("动态代理的开始...");
    Object invoke = method.invoke(object, args);
    System.out.println("动态代理的结束...");
    return invoke;
  }
}