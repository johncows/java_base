package com.kk.tcp.uploadFile;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author KK
 * @create 2019-05-13 21:02
 *
 * 1. socket 必须先建立连接 否则抛出异常(一旦构造 就开始连接)
 *
 **/
public class TcpClient {


    public static void sendMessage(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();

        FileInputStream fileInputStream = new FileInputStream("D:\\src\\output\\1.jpg");

        byte[] bytes = new byte[1024*20];
        fileInputStream.read(bytes);
        outputStream.write(bytes);

         bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        inputStream.read(bytes);

        System.out.println(new String(bytes));




    }
}
