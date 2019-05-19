package com.kk.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author KK
 * @create 2019-05-13 17:25
 *
 *  实现实时发送功能
 **/
public class BaseUDPDemo01 {
    public static void main(String[] args) throws Exception {

        new Thread(()->{
            try {
                    Thread.sleep(2000L);
                    function2();
            } catch (IOException |InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        function3();




    }




//    接受键盘输入 发送给8080端口
    public static void function2() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("请输入数据" );
            String msg = scanner.nextLine();
            byte[] data =  msg.getBytes();
            InetAddress inetAddress =  InetAddress.getByName("127.0.0.1");
            DatagramPacket datagramPacket = new DatagramPacket(data,data.length,inetAddress,8080);
            datagramSocket.send(datagramPacket);
        }



    }

//  接受8080端口接受到数据
    public static void function3() throws IOException{
        DatagramSocket datagramSocket = new DatagramSocket(8080);
        byte[] data = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);

        while (true){
            datagramSocket.receive(datagramPacket);
            System.out.println("-------------------------------------");
            System.err.println(new String(data,0,datagramPacket.getLength()));
            System.out.println("-------------------------------------");

        }

    }



}
