package com.kk.tcp.uploadFile;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author KK
 * @create 2019-05-13 21:18
 *
 * 1.必须要获得客户端的套接字对象
 **/
public class TcpServer {

    public static void receiveMessage() throws IOException {
        byte[] bytes = new byte[1024*20];

        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();

        socket.getInputStream().read(bytes);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\src\\input\\2.jpg");
        fileOutputStream.write(bytes);

        fileOutputStream.close();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("行了 我已经收到文件了 谢谢".getBytes());


        Socket accept = serverSocket.accept();

        if(socket==socket){
            System.out.println("hello ");
        }


        serverSocket.close();
    }
    @Test
    public void fun1() throws IOException {
        receiveMessage();
    }

    @Test
    public void fun2() throws IOException{
        TcpClient.sendMessage("127.0.0.1",8080);
    }



}
