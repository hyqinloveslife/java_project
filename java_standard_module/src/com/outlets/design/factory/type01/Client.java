/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Client
 * Author:   hyqin
 * Date:     2019-08-10 20:44
 * Description: 客户端类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.factory.type01;

/**
 * 〈一句话功能简述〉<br>
 * 〈客户端类〉
 *
 * @author hyqin
 * @create 2019-08-10
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
        IFacotry facotry = new DellFactory();
        IProduct product = facotry.createProduct();
        product.productMethod();


        DellComputer dell = (DellComputer) UnitFactory.createProduct(DellComputer.class);
        dell.productMethod();

        LenoveComputer lenove = (LenoveComputer) UnitFactory.createProduct(LenoveComputer.class);
        lenove.productMethod();

    }
}
