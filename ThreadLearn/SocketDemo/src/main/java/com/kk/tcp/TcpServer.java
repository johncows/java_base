package com.kk.tcp;

import org.junit.Test;
import org.testng.annotations.ITestAnnotation;
import sun.reflect.generics.tree.VoidDescriptor;

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
        byte[] bytes = new byte[1024];
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        socket.getInputStream().read(bytes);
        System.out.println(new String(bytes));

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务端已收到 谢谢".getBytes());



    }
    @Test
    public void fun1() throws IOException {
        receiveMessage();
    }

    @Test
    public void fun2() throws IOException{
        TcpClient.sendMessage("127.0.0.1",8080,"这个世界美味无穷");
    }



}
