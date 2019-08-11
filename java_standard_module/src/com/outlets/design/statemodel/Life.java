/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Life
 * Author:   hyqin
 * Date:     2019-08-05 22:22
 * Description: 电梯实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.statemodel;

/**
 * 〈一句话功能简述〉<br>
 * 〈电梯实现类〉
 *
 * @author hyqin
 * @create 2019-08-05
 * @since 1.0.0
 */
public class Life implements ILife {

    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (this.state) {
            case OPEN_STATE:

                break;
            case CLOSE_STATE:
                this.runWithoutLogic();
                this.setState(OPEN_STATE);
                break;
            case RUN_STATE:

                break;
            case STOP_STATE:
                this.openWithoutLogic();
                this.setState(OPEN_STATE);
                break;
        }
    }

    @Override
    public void close() {
        switch (this.state) {
            case OPEN_STATE:
                this.closeWithoutLogic();
                this.setState(OPEN_STATE);
                break;
            case CLOSE_STATE:

                break;
            case RUN_STATE:
                break;
            case STOP_STATE:
                break;
        }
    }

    @Override
    public void run() {
        switch (this.state) {
            case OPEN_STATE:

                break;
            case CLOSE_STATE:
                this.runWithoutLogic();
                this.setState(RUN_STATE);
                break;
            case RUN_STATE:
                break;
            case STOP_STATE:
                this.stopWithoutLogic();
                this.setState(RUN_STATE);
                break;
        }
    }

    @Override
    public void stop() {
        switch (this.state) {
            case OPEN_STATE:

                break;
            case CLOSE_STATE:
                this.stopWithoutLogic();
                this.setState(CLOSE_STATE);
                break;
            case RUN_STATE:
                this.stopWithoutLogic();
                this.setState(CLOSE_STATE);
                break;
            case STOP_STATE:
                break;
        }
    }

    //电梯门关闭了
    private void closeWithoutLogic() {
        System.out.println("电梯门关闭了...");
    }

    //电梯门开了
    private void openWithoutLogic() {
        System.out.println("电梯门开了...");
    }

    //电梯运行了
    private void runWithoutLogic() {
        System.out.println("电梯运行了...");
    }

    //电梯停止了
    private void stopWithoutLogic() {
        System.out.println("电梯停止了...");
    }

}
