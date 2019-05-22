package com.kk.udp;


import java.io.IOException;
import java.net.*;

/**
 * @author KK
 * @create 2019-05-13 17:25
 **/
public class BaseUDPDemo {
    public static void main(String[] args) throws Exception {

        new Thread(()->{
            try {
                Thread.sleep(2000L);
                function2();
            } catch (IOException |InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        function1();




    }



//    获得回环地址对象
    public  static void function1(){
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.println("loopbackAddress = " + loopbackAddress);
    }


/**
 *    Upd无连接 直接发送
 *    DatagramSocket仅具备发送udp包的功能
 *    DatagramPacket包含的信息有数据 地址(类比快递单号)
 */

    public static void function2() throws IOException {
        byte[] data = "你好啊 abc".getBytes();
        InetAddress inetAddress =  InetAddress.getByName("127.0.0.1");
        DatagramPacket datagramPacket = new DatagramPacket(data,data.length,inetAddress,8080);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }

    /**
     *    DatagramSocket具备接收数据包功能
     *    接收过程具备线程等待特点
     */
    public static void function3() throws IOException{
        DatagramSocket datagramSocket = new DatagramSocket(8080);
        byte[] data = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(data,0,datagramPacket.getLength()));
        System.out.println("datagramPacket = " + datagramPacket.getSocketAddress());
        


    }



}