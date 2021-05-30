package com.outlets.design.responsibility.demo0323;

import com.outlets.design.responsibility.demo0324.IUserAuthStrategy;
import java.util.HashMap;

/**
 * @description 核心门户处理
 * @author: huangyeqin
 * @create : 2021/3/24  14:12
 */
public class CorePortalHandler extends IHandler {

  public CorePortalHandler(int level) {
    super(1);
  }

  @Override
  public HashMap response(IUserAuthStrategy strategy) {
    System.out.println("调用核心门户的认证中心");
    System.out.println(strategy.getUser(new HashMap()));
    System.out.println("核心门户是否获取到了用户信息？");
    return null;
  }


}
