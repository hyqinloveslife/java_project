/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FileReaderThread
 * Author:   hyqin
 * Date:     2019-04-12 15:48
 * Description: use thread to read and explain the big data and big files
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.thread.pool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 〈一句话功能简述〉<br>
 * 〈use thread to read and explain the big data and big files〉
 *
 * @author hyqin
 * @create 2019-04-12
 * @since 1.0.0
 */
public class FileReaderThread implements Callable {
    private static BufferedReader br = null;
    private List<String> list;

    static {
        try {
            br = new BufferedReader(new FileReader("c://meitu/abc.txt"), 10);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object call() throws Exception {
        String line = null;
        int count = 0;
        while (true) {
            this.list = new ArrayList<>();
            synchronized (br) {
                while ((line = br.readLine()) != null) {
//                    line = new String(line.getBytes("utf-8"),"gbk");
                    if (count < 15) {
                        list.add(line);
                        count++;
                    } else {
                        list.add(line);
                        count = 0;
                        break;
                    }
                }
            }
            Thread.sleep(10);
            display(list);
            if (line == null) {
                break;
            }
        }
        return null;
    }

    public void display(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println(list.size());
    }

}
