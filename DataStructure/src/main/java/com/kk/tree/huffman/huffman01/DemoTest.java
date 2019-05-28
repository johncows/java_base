package com.kk.tree.huffman.huffman01;

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
        String str = "i love you not because of who you are ,but because of who you are but because of when i am with you";
        LinkedList<NodeData> nodeDatas = HuffmanTree.sortList(str);
//        System.out.println("nodeData = " + nodeData);
        HuffmanTreeNode hashManTree = HuffmanTree.createHashManTree(nodeDatas);
        HuffmanTree.showHaffmanTree(hashManTree);

       nodeDatas.forEach(e->{
           HuffmanTree.encoding(hashManTree,e.getData());
       });


       HuffmanTree.decoding("1110",hashManTree);






    }



}
