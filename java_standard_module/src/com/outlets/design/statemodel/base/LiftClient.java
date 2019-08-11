/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LiftClient
 * Author:   hyqin
 * Date:     2019-08-08 21:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.statemodel.base;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author hyqin
 * @create 2019-08-08
 * @since 1.0.0
 */
public class LiftClient {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new CloseState()); //定义初始化状态

        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
