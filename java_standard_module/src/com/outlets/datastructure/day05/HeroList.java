package com.outlets.datastructure.day05;

/**
 * @description 实现一个单链表
 * @author: hyqin
 * @create : 2020/6/30
 */
public class HeroList {

  //设置一个默认的头节点 ,没有值
  private HeroNode list;

  public HeroList() {
    list = new HeroNode(0, "", "");
  }

  /**
   * 添加数据(默认添加到末尾)
   */
  public void add(HeroNode node) {
    HeroNode temp = list;
    while (true) {
      if (temp.next != null) {
        temp = temp.next;
      } else {
        temp.next = node;
        temp = temp.next;
        break;
      }
    }
  }

  /**
   * 按编号添加
   */
  public void addByOrder(HeroNode node) {
    HeroNode p = list;
    boolean flag = false;
    while (true) {
      if (p.next == null) {
        break;
      }
      if (p.next.no > node.no) {  // 查找的当前节点比新插入的节点大
        break;
      } else if (p.next.no == node.no) {
        flag = true;
        break;
      }
      p = p.next;
    }

    if (flag) {
      System.out.println("该英雄已经存在");
    } else {
      node.next = p.next;
      p.next = node;
    }
  }

  /**
   * 删除节点
   */
  public void remove(HeroNode node) {

  }

  /**
   * 修改节点（根据编号）
   */
  public void update(HeroNode node) {

  }

  /**
   * 打印链表信息
   */
  public void list() {
    HeroNode temp = list;
    while (true) {
      if (temp.next == null) {
        break;
      } else {
        temp = temp.next;
        System.out.println(temp.toString());
      }
    }
  }
}
