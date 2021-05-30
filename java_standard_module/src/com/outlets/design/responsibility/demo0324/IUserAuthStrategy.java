package com.outlets.design.responsibility.demo0324;

import java.util.HashMap;

/**
 * @description 用户认证的策略接口
 * @author: huangyeqin
 * @create : 2021/3/24  12:03
 */
public interface IUserAuthStrategy {

  // 获取当前策略类型
  public int getType();

  // 一个策略接口
  HashMap getUser(HashMap param);

}
