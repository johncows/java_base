package com.kk.tcp;

import javafx.geometry.Pos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author KK
 * @create 2019-05-13 21:02
 *
 * 1. socket 必须先建立连接 否则抛出异常(一旦构造 就开始连接)
 * 2. 玩的就是字节流 区分写入写出对象
 *
 **/
public class TcpClient {


    public static void sendMessage(String host, int port,String msg) throws IOException {
        Socket socket = new Socket(host, port);
//        获得输出流
        OutputStream outputStream = socket.getOutputStream();
//        写入数据 并刷入
        outputStream.write(msg.getBytes());
        outputStream.flush();

        byte[] bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
//        具备线程等待特性
        inputStream.read(bytes);
        System.out.println("bytes = " + new String(bytes));


    }
}
