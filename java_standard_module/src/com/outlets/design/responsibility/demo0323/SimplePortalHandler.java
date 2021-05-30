package com.outlets.design.responsibility.demo0323;

import com.outlets.design.responsibility.demo0324.IUserAuthStrategy;
import java.util.HashMap;

/**
 * @description 简单前台两定门户
 * @author: huangyeqin
 * @create : 2021/3/24  14:18
 */
public class SimplePortalHandler extends IHandler {

  public SimplePortalHandler(int level) {
    super(4);
  }

  @Override
  public HashMap response(IUserAuthStrategy strategy) {
    System.out.println("调用简单前台门户的认证中心");
    System.out.println(strategy.getUser(new HashMap()));
    System.out.println("简单前台门户是否获取到了用户信息？");
    return null;
  }
}
