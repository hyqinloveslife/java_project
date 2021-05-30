package com.outlets.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/3/17  20:38
 */
public class MyProxy {

  public static void main(String[] args) {
//    doProxy();

    doProxy2();
  }

  // 实现jdk动态代理的时候要特别注意，外部的参数，只能通过构造方法传进来，不然就会栈溢出 ，特别是不能写 method.invoke(proxxy,args)
  public static void doProxy() {
    UserService o = (UserService) Proxy
        .newProxyInstance(MyProxy.class.getClassLoader(), new Class[]{UserService.class},
            new InvocationHandler() {
              @Override
              public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前置通知");
                System.out.println("hello : " + args[0]);
                System.out.println("后置通知");
                return null;
              }
            });
    o.sayHello("张三");
  }

  // 如果想要实现那个实现类的 方法，必须把实现类传进来
  public static void doProxy2() {
    UserService userService = (UserService) Proxy
        .newProxyInstance(MyProxy.class.getClassLoader(), new Class[]{UserService.class},
            new MyInvocationHandler(new UserServiceImpl()));
    userService.sayHello("卡牌大师刘谦 ");
  }

}

class MyInvocationHandler implements InvocationHandler {

  public Object obj;

  public MyInvocationHandler(Object obj) {
    this.obj = obj;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("前置增强");
    method.invoke(obj, args);
    System.out.println("后置增强");
    return null;
  }
}


class UserServiceImpl implements UserService {

  @Override
  public void sayHello(String name) {
    System.out.println(" hello :" + name);
  }
}

interface UserService {

  void sayHello(String name);
}
