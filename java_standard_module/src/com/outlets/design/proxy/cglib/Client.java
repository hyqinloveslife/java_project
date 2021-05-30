package com.outlets.design.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/17  12:17
 */
public class Client {

  public static void main(String[] args) {
    //在指定目录下生成动态代理类，我们可以反编译看一下里面到底是一些什么东西
    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
        "D:\\MySpace\\IdeaZone\\java_project\\java_standard_module");

    //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
    Enhancer enhancer = new Enhancer();

    enhancer.setSuperclass(Dog.class);

    enhancer.setCallback(new MyMethodInterceptor());

    Dog proxyDog = (Dog) enhancer.create();

    proxyDog.eat();
  }
}
