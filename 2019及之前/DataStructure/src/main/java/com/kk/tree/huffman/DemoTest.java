package com.kk.tree.huffman;

import java.util.LinkedList;

/**
 * @author KK
 * @create 2019-05-21 21:43
 **/
public class DemoTest {

    public static LinkedList<Integer> weightList = new LinkedList<>();


//    初始化一个排序好的权值队列
    public static void init(){
        for(int i = 1;i<5;i++)
        {
            weightList.add(i);
        }
        System.out.println("weightList = " + weightList);
    }


    public static void main(String[] args) {

        init();


        HuffmanTreeNode hashManTree = HuffmanTree.createHashManTree(weightList);

        HuffmanTree.showHaffmanTree(hashManTree);


    }



}
