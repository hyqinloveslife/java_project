/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Client
 * Author:   hyqin
 * Date:     2019-08-05 22:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.statemodel;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author hyqin
 * @create 2019-08-05
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
        ILife life = new Life();

        life.setState(ILife.STOP_STATE);


        life.open();
        life.close();

        life.run();

        life.stop();
    }
}
