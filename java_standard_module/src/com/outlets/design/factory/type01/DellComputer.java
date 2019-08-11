/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LenoveComputer
 * Author:   hyqin
 * Date:     2019-08-10 20:38
 * Description: 定义一个联想笔记本的产品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.factory.type01;

/**
 * 〈一句话功能简述〉<br>
 * 〈定义一个戴尔笔记本的产品〉
 *
 * @author hyqin
 * @create 2019-08-10
 * @since 1.0.0
 */
public class DellComputer implements IProduct {
    @Override
    public void productMethod() {
        System.out.println("生产戴尔笔记本");

    }
}
