package com.outlets.datastructure.day05;

/**
 * @description 测试
 * @author: hyqin
 * @create : 2020/6/30
 */
public class HeroNodeTest {

  public static void main(String[] args) {
    HeroList list = new HeroList();
    HeroNode songjiang = new HeroNode(1, "宋江", "及时雨");
    HeroNode lujunyi = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode wuyong = new HeroNode(3, "吴用", "智多星");
    HeroNode lingchong = new HeroNode(4, "林冲", "豹子头");

//        list.add(songjiang);
//        list.add(lingchong);
//        list.add(lujunyi);
//        list.add(wuyong);
    list.addByOrder(songjiang);
    list.addByOrder(wuyong);
    list.addByOrder(lingchong);
    list.addByOrder(lujunyi);
    list.list();

  }
}
