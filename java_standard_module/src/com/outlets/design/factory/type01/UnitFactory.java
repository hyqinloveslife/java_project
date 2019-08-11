/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UnitFactory
 * Author:   hyqin
 * Date:     2019-08-10 21:49
 * Description: 混合代工厂，可以生产所有的产品
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.factory.type01;

/**
 * 〈一句话功能简述〉<br>
 * 〈混合代工厂，可以生产所有的产品〉
 *
 * @author hyqin
 * @create 2019-08-10
 * @since 1.0.0
 */
public class UnitFactory {
    public static IProduct createProduct(Class c) {
        IProduct product = null;

        try {
            product = (IProduct) Class.forName(c.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("没有找到找到这个产品");
        } catch (IllegalAccessException e) {
            System.out.println("产品定义错误");
        } catch (InstantiationException e) {
            System.out.println("必须指定产品");
        }

        return product;
    }
}
