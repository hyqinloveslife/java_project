/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TransactionState
 * Author:   hyqin
 * Date:     2019-07-23 22:30
 * Description: 状态模式的设计
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.statemodel;

/**
 * 〈一句话功能简述〉<br>
 * 〈状态模式的设计〉
 *
 * @author hyqin
 * @create 2019-07-23
 * @since 1.0.0
 */
public class TransactionState {

    abstract class personInsuredChange {
        //调入
        public abstract int moveIn();

        //调出
        public abstract int moveOut();

        //人员减少
        public abstract int personReduce();

        //人员增加
        public abstract int personAdd();

    }

    interface personInsuredTrans {
        int moveIn();

        int moveOut();

        int personReduce();

        int personAdd();
    }


}
