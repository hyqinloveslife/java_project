/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CloseState
 * Author:   hyqin
 * Date:     2019-08-08 21:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.statemodel.base;

/**
 * 〈一句话功能简述〉<br>
 * 〈关闭电梯门后，可以开门，可以运行，可以停止什么都不做〉
 *
 * @author hyqin
 * @create 2019-08-08
 * @since 1.0.0
 */
public class CloseState extends LiftState {
    @Override
    public void close() {
        System.out.println("电梯门关了");
    }

    @Override
    public void open() {
        super.context.setLiftState(Context.OPENNING_STATE);
        super.context.getLiftState().open();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOPING_STATE);
        super.context.getLiftState().stop();
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.RUN_STATE);
        super.context.getLiftState().run();
    }
}
