package com.outlets.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description 服务端
 * @author: huangyeqin
 * @create : 2021/2/10  16:49
 */
public class ServerSocketMain {

  /**
   * 1、初始化socket 2、绑定端口 3、监听端口 4、进入阻塞 5、等待客户端连接 6、获取客户端内容
   */

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    String readLine = "";

    byte[] bytes = new byte[1024];
    // 设置监听的端口
    int port = 4000;

    // 实例化socket并且绑定端口
    ServerSocket serverSocket = new ServerSocket(port);

    // 进入阻塞
    Socket accept = serverSocket.accept();
    BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));

    // 获取客户端传输的内容
    InputStream inputStream = accept.getInputStream();

    // 所以说，dubbo的底层原理，就是调用服务端的运算结果？用来传输对象？
    ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());

    // 把内容解析出来
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    while (!readLine.equalsIgnoreCase("bye")) {
      System.out.println("服务端接收到的内容是：");
//      System.out.println(reader.readLine());

      CommonDTO o = (CommonDTO) objectInputStream.readObject();
      System.out.println("==>" + o.toString());

      readLine = systemIn.readLine();

    }
  }

}
