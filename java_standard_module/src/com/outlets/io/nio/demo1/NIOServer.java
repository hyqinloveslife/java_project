package com.outlets.io.nio.demo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description nio的服务端
 * @author: huangyeqin
 * @create : 2021/4/12  14:15
 */
public class NIOServer {

  private int port;
  private Selector selector;
  private ExecutorService service = Executors.newFixedThreadPool(5);

  public NIOServer(int port) {
    this.port = port;
  }

  // 一些初始化操作
  public void init() {
    ServerSocketChannel ssc = null;
    try {
      ssc = ServerSocketChannel.open();
      ssc.configureBlocking(false);
      ssc.bind(new InetSocketAddress(port));
      selector = Selector.open();
      ssc.register(selector, SelectionKey.OP_ACCEPT);
      System.out.println("nio server start ...");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void accept(SelectionKey key) {
    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
    SocketChannel sc;
    try {
      sc = ssc.accept();
      sc.configureBlocking(false);
      sc.register(selector, SelectionKey.OP_READ);
      System.out.println("accept a client: " + sc.socket().getInetAddress().getHostName());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void start() {
    this.init();
    while (true) {
      try {
        int events = selector.select();
        if (events > 0) {
          Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
          while (iterator.hasNext()) {
            SelectionKey next = iterator.next();
            iterator.remove();
            if (next.isAcceptable()) {
              accept(next);
            } else {
              service.submit(new NioServerHandler(next));
            }
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    new NIOServer(8099).start();
  }

  public class NioServerHandler implements Runnable {

    private SelectionKey selectionKey;

    public NioServerHandler(SelectionKey selectionKey) {
      this.selectionKey = selectionKey;
    }

    @Override
    public void run() {
      try {
        if (selectionKey.isReadable()) {
          SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
          ByteBuffer buffer = ByteBuffer.allocate(1024);
          socketChannel.read(buffer);
          buffer.flip();
          System.out.println(
              "收到客户端 " + socketChannel.socket().getInetAddress().getHostName() + " 的数据 :"
                  + new String(buffer.array()));
          // 讲数据添加到key
          ByteBuffer outByffer = ByteBuffer.wrap(buffer.array());
          socketChannel.write(outByffer); //将消息发给客户端
          selectionKey.cancel();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
