package com.kk.tcp.uploadFile;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author KK
 * @create 2019-05-13 22:52
 *
 *  让传输文件具备了并行化
 **/
public class ThreadSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true){
            Socket accept = serverSocket.accept();
            new Thread(()->{
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();


        }




    }
}
