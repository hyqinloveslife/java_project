package com.outlets.design.proxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @description 方法拦截器
 * @author: huangyeqin
 * @create : 2021/4/17  12:15
 */
public class MyMethodInterceptor implements MethodInterceptor {

  @Override
  public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("这里对目标类进行增强");
    Object obj = methodProxy.invokeSuper(o, args);
    return obj;
  }
}
