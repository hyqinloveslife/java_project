package com.outlets.base.day02;

public interface MyCorp {
    //生产
    void produce();

    //销售
    void sell();

    default void makeMoney(){
        this.produce();
        this.sell();
    }

}
