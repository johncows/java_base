package com.kk;

import java.io.FileReader;
import java.io.IOException;

/*
 *  读取字节流文件
 */
public class FileDemo {

//   基本读取字节流文件
    public static void readFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        int s ;
        while ((s=fileReader.read())!=-1){
            System.out.print( (char)s);
        }
    }


    public static void readStream(String path) throws IOException {
//        InputStreamReader


    }


    public static void main(String[] args) throws IOException {
        String path = "D:\\StudyDemo\\FileSteam\\src\\a.txt";
        FileDemo.readFile(path);
    }


}
