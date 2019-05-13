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
 *
 **/
public class TcpClient {


    public static void sendMessage(String host, int port,String msg) throws IOException {
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(msg.getBytes());
        outputStream.flush();

        byte[] bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        inputStream.read(bytes);
        System.out.println("bytes = " + new String(bytes));


    }
}
