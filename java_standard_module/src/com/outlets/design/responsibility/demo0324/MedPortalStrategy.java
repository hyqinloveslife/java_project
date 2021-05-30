package com.outlets.design.responsibility.demo0324;

import java.util.HashMap;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/3/24  14:00
 */
public class MedPortalStrategy implements IUserAuthStrategy {

  @Override
  public int getType() {
    return 2;
  }

  @Override
  public HashMap getUser(HashMap param) {
    HashMap hashMap = new HashMap();
    hashMap.put("user", "两定云药店门户");
    return hashMap;
  }
}
