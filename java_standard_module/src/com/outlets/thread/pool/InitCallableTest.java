/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: InitCallableTest
 * Author:   hyqin
 * Date:     2019-04-11 15:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br>
 * 〈想用线程池去创建多个线程，然后去读取同一个人文件中的内容。文件内容虽然读出来了，但是顺序却会乱。
 * 为什么会导致这种情况？〉
 *
 * @author hyqin
 * @create 2019-04-11
 * @since 1.0.0
 */
public class InitCallableTest {
    private final static int MAX_THREAD = 4;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(MAX_THREAD);
        FileReaderThread f1 = new FileReaderThread();
        FileReaderThread f2 = new FileReaderThread();
        service.submit(f1);

        service.submit(f2);
        service.shutdown();
    }
}
