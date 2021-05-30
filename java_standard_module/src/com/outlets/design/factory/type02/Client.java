package com.outlets.design.factory.type02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/3/6  23:37
 */
public class Client {

  public static void main(String[] args) {
    IGenericFactory factory = (IGenericFactory) Proxy
        .newProxyInstance(Client.class.getClassLoader(), new Class[]{IGenericFactory.class},
            new InvocationHandler() {
              @Override
              public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getDeclaringClass().getTypeName());
                System.out.println(method.getGenericReturnType());
                System.out.println(method.getReturnType().getGenericInterfaces());
                System.out.println(method.getGenericReturnType().getTypeName()
                    .substring(method.getGenericReturnType().getTypeName().indexOf("<") + 1,
                        method.getGenericReturnType().getTypeName().indexOf(">")));
                String className = method.getGenericReturnType().getTypeName()
                    .substring(method.getGenericReturnType().getTypeName().indexOf("<") + 1,
                        method.getGenericReturnType().getTypeName().indexOf(">"));
                Class<?> aClass = Class.forName(className);
                return null;
              }
            });

    factory.selectList("红富士");
  }
}
