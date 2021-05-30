package com.outlets.design.command.demo1;

/**
 * @description 命令类
 * @author: huangyeqin
 * @create : 2021/4/19  8:55
 */
public abstract class Command {

  protected RequirementGroup requirementGroup = new RequirementGroup();

  protected PageGroup pageGroup = new PageGroup();

  protected CodeGroup codeGroup = new CodeGroup();

  // 具体的执行
  public abstract void execute();

}

/**
 * 由于find()和plan()是永远都会执行的一段，所以这里可以用模板方法模式
 *
 * @Author : huangyeqin
 * @Date : 2021/4/19 9:12
 */
class RequirementAddCommand extends Command {

  @Override
  public void execute() {
    // 找到人
    requirementGroup.find();

    // 增加需求
    requirementGroup.add();

    // 页面也要增加
    pageGroup.add();

    // 代码也要增加
    codeGroup.add();

    // 给出计划
    requirementGroup.plan();
  }
}


class PageChangeCommand extends Command {

  @Override
  public void execute() {
    // 找到美工组
    pageGroup.find();

    // 变更页面
    pageGroup.change();

    // 给出计划
    pageGroup.plan();

  }
}

class CodeDeleteCommand extends Command {

  @Override
  public void execute() {
    // 找到代码组
    codeGroup.find();

    // 删除一段代码
    codeGroup.delete();

    // 给出计划
    codeGroup.plan();
  }
}