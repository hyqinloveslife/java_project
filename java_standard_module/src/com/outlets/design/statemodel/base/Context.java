/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Context
 * Author:   hyqin
 * Date:     2019-08-08 21:35
 * Description: 上下文类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.statemodel.base;

/**
 * 〈一句话功能简述〉<br>
 * 〈上下文类〉
 *
 * @author hyqin
 * @create 2019-08-08
 * @since 1.0.0
 */
public class Context {
    public final static OpenningState OPENNING_STATE = new OpenningState();
    public final static CloseState CLOSE_STATE = new CloseState();
    public final static RunState RUN_STATE = new RunState();
    public final static StopingState STOPING_STATE = new StopingState();

    private LiftState liftState;

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public LiftState getLiftState() {
        return liftState;
    }


    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }

    public void open() {
        this.liftState.open();
    }


}
