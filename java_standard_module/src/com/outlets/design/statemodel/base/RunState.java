/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RunState
 * Author:   hyqin
 * Date:     2019-08-08 21:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.statemodel.base;

/**
 * 〈一句话功能简述〉<br>
 * 〈电梯运行的状态，可以停止〉
 *
 * @author hyqin
 * @create 2019-08-08
 * @since 1.0.0
 */
public class RunState extends LiftState {
    @Override
    public void close() {

    }

    @Override
    public void open() {

    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOPING_STATE);
        super.context.getLiftState().stop();
    }

    @Override
    public void run() {
        System.out.println("电梯在上下跑");
    }
}
