package com.outlets.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description 客户端
 * @author: huangyeqin
 * @create : 2021/2/10  16:49
 */
public class ClientSocketMain {

  public static void main(String[] args) throws IOException {

    String readLine = "";

    String ipAddr = "127.0.0.1";
    int port = 4000;

    Socket socket = new Socket(ipAddr, port);

    PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

    BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));

    CommonDTO commonDTO = new CommonDTO();
    commonDTO.setName("张三");
    commonDTO.setAddress("湖南省岳阳市君山区");
    commonDTO.setAge(18);

    while (!readLine.equalsIgnoreCase("bye")) {

      readLine = systemIn.readLine();

//      writer.println(readLine);
//      writer.flush();

      objectOutputStream.writeObject(commonDTO);
      objectOutputStream.flush();
    }

  }
}
