package com.kk.tree.huffman;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author KK
 * @create 2019-05-21 21:48
 *
 * 实现功能:
 * 1. 传入一个有序的权值数组
 * 2. 每次拿一个值 判断合并后 自动生成下一个节点
 *
 **/


public class HuffmanTree {



    public static HuffmanTreeNode createHashManTree(LinkedList<Integer> weightList){

//        获取迭代器
        Iterator<Integer> iterator = weightList.iterator();


//      构造一个节点 暂时不删除第一个节点
        HuffmanTreeNode headNode = HuffmanTreeNode.createHuffmanTreeNode(iterator.next());


        while (iterator.hasNext()){
            HuffmanTreeNode node = HuffmanTreeNode.createHuffmanTreeNode(iterator.next());
            int totalWeight  = node.getWeight() + headNode.getWeight();
            HuffmanTreeNode huffmantreeNode = HuffmanTreeNode.createHuffmanTreeNode(totalWeight);

            if(headNode.getWeight() > node.getWeight()){
                huffmantreeNode.setLeft(node);
                huffmantreeNode.setRight(headNode);
            }else {
                huffmantreeNode.setLeft(headNode);
                huffmantreeNode.setRight(node);
            }
            headNode =  huffmantreeNode;
        }

        return headNode;
    }



    public static void showHaffmanTree(HuffmanTreeNode huffmanTreeNode){
        if(huffmanTreeNode == null){
                return;
        }
        System.out.print(huffmanTreeNode.getWeight()+"<->");
        showHaffmanTree(huffmanTreeNode.getLeft());
        showHaffmanTree(huffmanTreeNode.getRight());
    }


}
