/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HummerModel
 * Author:   hyqin
 * Date:     2019-08-11 13:26
 * Description: 悍马模型车
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.templateMethod.type01;

/**
 * 〈一句话功能简述〉<br>
 * 〈悍马模型车〉
 * 把方法定义成protected类型的，就是为了防止该方法在别的包种被调用
 *
 * @author hyqin
 * @create 2019-08-11
 * @since 1.0.0
 */
public abstract class HummerModel {

    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void run();

    protected abstract void engineBoom();

    /**
     * 模板方法
     */
    public final void templateMethod() {
        this.start();
        this.engineBoom();
        this.run();
        if (isAlarm()) {
            this.alarm();
        }
        this.stop();
    }

    /**
     * 钩子方法
     *
     * @return
     */
    protected boolean isAlarm() {
        return true;
    }


}
