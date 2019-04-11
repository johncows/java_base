package com.kk;

import java.io.*;
import java.util.Date;

/*
 *  读取字节流文件
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {
//        String path = "D:\\fileSrc";
//        FileDemo.showFolder(path);


        String path1 = "D:\\fileSrc\\char.txt";
        String path2 = "D:\\fileSrc\\song.mp3";

//        readFileByChar(path1);
//          writeFileByStream(path2);

        long time = new Date().getTime();
        writeFileByChar(path1);
        System.out.println("该操作耗时" + (new Date().getTime()-time)+"毫秒");

    }

    //读取文件夹中的文件及其属性
    public static void showFolder(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println("file1.length() = " + file1.length());
        }
    }


//    以字节流的形式读取文件
    public static void readFileByStream(String path) throws IOException {
        
        FileInputStream fls = new FileInputStream(path);

        System.out.println("该文件字节数 : " + fls.available());
        int temp ;
        while ((temp = fls.read())!=-1){
            System.out.print(temp+" ");
        }
        fls.close();
    }


    /**
     * 代码解析
     *      fileReader默认解析为UTF-8 再 InputStreamReader是 FIleReader的子类
     *      通过构造函数即可理解
     *      BufferedReader作为缓冲区 原因是 fileReader.nextLine 的底层是 先获取字节再转为字符
     * @param path
     * @throws IOException
     */
    public static  void readFileByChar(String path) throws IOException {

        FileReader fileReader = new FileReader(path);

//      InputStreamReader fileReader = new InputStreamReader(new FileInputStream(path), "GBK");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String temp = bufferedReader.readLine();
        while (temp!=null){
            System.out.println(temp);
            temp = bufferedReader.readLine();
        }
    }



    /**
     *
     * 1.字节流写入 逐字节写入
     * 2.自定义一个字节数组 在以字节数组写出(快)
     *
    */
    public static void writeFileByStream(String path) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(path);

        File file = new File("D:\\fileSrc\\song1.mp3");
        file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);


        byte[] bytes =new  byte[1024];


        while(true){
            int length = fileInputStream.read(bytes);
            if(length==1024){
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
            }else{
                fileOutputStream.write(bytes,0,length);
                fileOutputStream.flush();
                break;
            }

        }

        fileInputStream.close();
        fileOutputStream.close();


    }


//    以字符缓冲输入流的读取字符 并以字符缓冲输出流写出
    public static void writeFileByChar(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        File file = new File("D:\\fileSrc\\char1.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        while(true){

            String temp = bufferedReader.readLine();
            if (temp==null) break;

            bufferedWriter.write(temp);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();


    }




}
