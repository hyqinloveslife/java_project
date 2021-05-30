package com.outlets.design.prototype;

/**
 * @description 原型模式调用
 * @author: huangyeqin
 * @create : 2020/12/16  23:10
 */
public class Client {

  public static void main(String[] args) {
    Sheep sheep = new Sheep("汤姆", "1", "白色");
    sheep.setFriend(new Cat("杰瑞", "老鼠洞"));
    Sheep sheep2 = (Sheep) sheep.clone();
    Sheep sheep3 = (Sheep) sheep.clone();
    Sheep sheep4 = (Sheep) sheep.clone();

    // 得出结论，克隆出来的是新的对象;
    System.out.println("sheep:" + sheep + " sheep.cat:" + sheep.getFriend());
    System.out.println("sheep2:" + sheep2 + " sheep2.cat:" + sheep2.getFriend());
    System.out.println("sheep3:" + sheep3 + " sheep3.cat:" + sheep3.getFriend());
    System.out.println("sheep4:" + sheep4 + " sheep4.cat:" + sheep4.getFriend());

  }
}
