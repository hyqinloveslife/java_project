package com.outlets.design.command.demo1;

/**
 * @description 业务组
 * @author: huangyeqin
 * @create : 2021/4/19  8:52
 */
public abstract class Group {

  // 增加
  public abstract void add();

  // 删除
  public abstract void delete();

  // 变更
  public abstract void change();

  // 查找
  public abstract void find();

  // 计划
  public abstract void plan();

}

class RequirementGroup extends Group {

  @Override
  public void add() {
    System.out.println("新增需求");
  }

  @Override
  public void delete() {
    System.out.println("减少需求");
  }

  @Override
  public void change() {
    System.out.println("变更需求");
  }

  @Override
  public void find() {
    System.out.println("找需求组的人");
  }

  @Override
  public void plan() {
    System.out.println("列需求计划");
  }
}

class PageGroup extends Group {

  @Override
  public void add() {
    System.out.println("新增页面");
  }

  @Override
  public void delete() {
    System.out.println("删除页面");
  }

  @Override
  public void change() {
    System.out.println("优化页面");
  }

  @Override
  public void find() {
    System.out.println("找美工团队");
  }

  @Override
  public void plan() {
    System.out.println("制定美工的计划");
  }
}

class CodeGroup extends Group {

  @Override
  public void add() {
    System.out.println("新增代码");
  }

  @Override
  public void delete() {
    System.out.println("删除代码");
  }

  @Override
  public void change() {
    System.out.println("修改代码");
  }

  @Override
  public void find() {
    System.out.println("找代码组的");
  }

  @Override
  public void plan() {
    System.out.println("制定代码计划");
  }
}