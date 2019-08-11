/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: StopingState
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
 * 〈电梯停止的时候，可以开门，可以运行〉
 *
 * @author hyqin
 * @create 2019-08-08
 * @since 1.0.0
 */
public class StopingState extends LiftState {
    @Override
    public void close() {

    }

    @Override
    public void open() {
        super.context.setLiftState(Context.OPENNING_STATE);
        super.context.getLiftState().open();
    }

    @Override
    public void stop() {
        System.out.println("电梯停了");
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.RUN_STATE);
        super.context.getLiftState().run();
    }
}
