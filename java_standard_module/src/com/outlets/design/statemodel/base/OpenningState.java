/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OpenningState
 * Author:   hyqin
 * Date:     2019-08-08 21:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.statemodel.base;

/**
 * 〈一句话功能简述〉<br>
 * 〈电梯门打开的状态，可以关闭〉
 *
 * @author hyqin
 * @create 2019-08-08
 * @since 1.0.0
 */
public class OpenningState extends LiftState {
    @Override
    public void close() {
        super.context.setLiftState(Context.CLOSE_STATE);
        super.context.getLiftState().close();
    }

    @Override
    public void open() {
        System.out.println("电梯门开了");
    }

    @Override
    public void stop() {

    }

    @Override
    public void run() {

    }
}
