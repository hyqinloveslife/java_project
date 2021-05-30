package com.outlets.datastructure.day05;

/**
 * @description 英雄的节点
 * @author: hyqin
 * @create : 2020/6/30
 */
public class HeroNode {

  //实现一个单链表的结点
  int no; //英雄排名
  String name; //英雄名字
  String nickName;//英雄绰号

  HeroNode next; //指向下一个英雄

  public HeroNode(int no, String name, String nickName) {
    this.no = no;
    this.name = name;
    this.nickName = nickName;
  }

  @Override
  public String toString() {
    return "HeroNode{" +
        "no=" + no +
        ", name='" + name + '\'' +
        ", nickName='" + nickName + '\'' +
        '}';
  }
}
