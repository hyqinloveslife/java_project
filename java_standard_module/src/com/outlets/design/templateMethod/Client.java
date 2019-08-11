/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Client
 * Author:   hyqin
 * Date:     2019-08-11 13:34
 * Description: 客户端类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.templateMethod;

import com.outlets.design.templateMethod.type01.HummerModel;
import com.outlets.design.templateMethod.type01.HummerModelImpl;
import com.outlets.design.templateMethod.type01.ToyotaModelImpl;

/**
 * 〈一句话功能简述〉<br>
 * 〈客户端类〉
 *
 * @author hyqin
 * @create 2019-08-11
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
        HummerModel toyota = new ToyotaModelImpl();
        toyota.templateMethod();

        HummerModel hummer = new HummerModelImpl();
        hummer.templateMethod();
    }
}
