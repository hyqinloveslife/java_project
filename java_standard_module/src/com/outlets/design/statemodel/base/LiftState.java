/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LiftState
 * Author:   hyqin
 * Date:     2019-08-08 21:35
 * Description: 电梯状态抽象类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.statemodel.base;

/**
 * 〈一句话功能简述〉<br>
 * 〈电梯状态抽象类〉
 *
 * @author hyqin
 * @create 2019-08-08
 * @since 1.0.0
 */
public abstract class LiftState {
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void close();

    public abstract void open();

    public abstract void stop();

    public abstract void run();
}

