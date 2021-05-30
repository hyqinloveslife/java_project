package com.outlets.design.responsibility.demo0324;

import java.util.HashMap;

/**
 * @description 核心门户的处理
 * @author: huangyeqin
 * @create : 2021/3/24  13:46
 */
public class CorePortalStragety implements IUserAuthStrategy {

  @Override
  public int getType() {
    return 1;
  }

  @Override
  public HashMap getUser(HashMap param) {
    HashMap hashMap = new HashMap();
    hashMap.put("user", "核心经办门户");
    return hashMap;
  }
}
