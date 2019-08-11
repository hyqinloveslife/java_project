package com.outlets.design.statemodel;

/**
 * 电梯接口
 */
public interface ILife {
    //电梯的4个状态
    int OPEN_STATE = 1;
    int CLOSE_STATE = 2;
    int RUN_STATE = 3;
    int STOP_STATE = 4;

    void setState(int state);

    //打开电梯门
    void open();

    void close();

    void run();

    void stop();

}
