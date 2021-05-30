package com.outlets.io.nio.demo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @description nio的客户端
 * @author: huangyeqin
 * @create : 2021/4/12  14:30
 */
public class NIOClient {

  private static final String host = "127.0.0.1";
  private static final int port = 8099;

  private Selector selector;

  // 连接
  public void connect(String host, int port) {
    try {
      SocketChannel sc = SocketChannel.open();
      sc.configureBlocking(false);
      this.selector = Selector.open();
      sc.register(selector, SelectionKey.OP_CONNECT);
      sc.connect(new InetSocketAddress(host, port));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 监听
  public void listen() {
    while (true) {
      try {
        int events = selector.select();
        if (events > 0) {
          Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
          while (iterator.hasNext()) {
            SelectionKey key = iterator.next();
            iterator.remove();
            // 连接事件
            if (key.isConnectable()) {
              SocketChannel socketChannel = (SocketChannel) key.channel();
              if (socketChannel.isConnectionPending()) {
                socketChannel.finishConnect();
              }
              socketChannel.configureBlocking(false);
              socketChannel.register(selector, SelectionKey.OP_READ);
              socketChannel.write(ByteBuffer
                  .wrap(("hello this is " + Thread.currentThread().getName()).getBytes()));
            } else if (key.isReadable()) {
              SocketChannel socketChannel = (SocketChannel) key.channel();
              ByteBuffer buffer = ByteBuffer.allocate(1024);
              socketChannel.read(buffer);
              buffer.flip();
              System.out.println("收到服务端消息:" + new String(buffer.array()));
            }
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 3; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          NIOClient client = new NIOClient();
          client.connect(host, port);
          client.listen();
        }
      }).start();
    }
  }

}
