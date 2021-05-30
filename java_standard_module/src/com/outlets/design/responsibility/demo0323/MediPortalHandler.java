package com.outlets.design.responsibility.demo0323;

import com.outlets.design.responsibility.demo0324.IUserAuthStrategy;
import java.util.HashMap;

/**
 * @description 两定云药店的门户处理
 * @author: huangyeqin
 * @create : 2021/3/24  14:16
 */
public class MediPortalHandler extends IHandler {

  public MediPortalHandler(int level) {
    super(2);
  }

  @Override
  public HashMap response(IUserAuthStrategy strategy) {
    System.out.println("调用两定云药店门户的认证中心");
    System.out.println(strategy.getUser(new HashMap()));
    System.out.println("定云药店门户是否获取到了用户信息？");
    return null;
  }
}
