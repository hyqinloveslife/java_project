package com.outlets.design.decorator.demo1;

/**
 * @description 一个客户端类
 * @author: huangyeqin
 * @create : 2021/4/16  22:17
 */
public class Client {

  public static void main(String[] args) {
    // 定义一个正品的店，需要对这家店进行一点装饰
    TopSports trueStore = new GenuineStores();

    // 定义一个新的店，把正品的店集成进来
    TopSports xtep = new XtepSports(trueStore);
    xtep.sell();

    // 可以双层装饰,通过这种方法，可以多层装饰
    TopSports liNing = new LiNingSports(xtep);
    liNing.sell();

    // 多层装饰，会涉及到递归问题吗
    TopSports adidas = new AdidasSports(liNing);
    adidas.sell();
  }
}
