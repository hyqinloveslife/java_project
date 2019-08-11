/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DellFactory
 * Author:   hyqin
 * Date:     2019-08-10 20:40
 * Description: 戴尔笔记本工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.factory.type01;

/**
 * 〈一句话功能简述〉<br>
 * 〈联想笔记本工厂〉
 *
 * @author hyqin
 * @create 2019-08-10
 * @since 1.0.0
 */
public class LenoveFactory implements IFacotry {
    @Override
    public IProduct createProduct() {
        return new LenoveComputer();
    }
}
