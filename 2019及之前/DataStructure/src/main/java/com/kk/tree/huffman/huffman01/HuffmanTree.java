package com.kk.tree.huffman.huffman01;

import java.util.*;

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


    public static HuffmanTreeNode createHashManTree(LinkedList<NodeData> weightList) {

//        获取迭代器
        Iterator<NodeData> iterator = weightList.iterator();


//      构造一个节点 从集合头部取出
        HuffmanTreeNode headNode = HuffmanTreeNode.createHuffmanTreeNode(iterator.next());


        while (iterator.hasNext()) {
            HuffmanTreeNode node = HuffmanTreeNode.createHuffmanTreeNode(iterator.next());

            int totalWeight = node.getNodeData().weight + headNode.getNodeData().weight;

//            非叶子节点
            HuffmanTreeNode huffmantreeNode = HuffmanTreeNode.createHuffmanTreeNode(new NodeData(totalWeight, null));

            if (headNode.getNodeData().weight > node.getNodeData().weight) {
                huffmantreeNode.setLeft(node);
                huffmantreeNode.setRight(headNode);
            } else {
                huffmantreeNode.setLeft(headNode);
                huffmantreeNode.setRight(node);
            }
            headNode = huffmantreeNode;
        }

        return headNode;
    }


    public static void showHaffmanTree(HuffmanTreeNode huffmanTreeNode) {
        if (huffmanTreeNode == null) {
            return;
        }
        if (huffmanTreeNode.getNodeData().data != null)
            System.out.print(huffmanTreeNode.getNodeData().getData() + "==>");
        showHaffmanTree(huffmanTreeNode.getLeft());
        showHaffmanTree(huffmanTreeNode.getRight());
    }


    public static LinkedList<NodeData> sortList(String str) {
        int[] ints = new int[256];
        for (char ch : str.toCharArray()) {
            ints[ch]++;
        }
        LinkedList<NodeData> nodeDatas = new LinkedList<>();

        for (int i = 0; i < 256; i++) {
            if (ints[i] != 0) {
                NodeData nodeData = new NodeData(ints[i], (char) i);
                nodeDatas.add(nodeData);
            }
        }
        Collections.sort(nodeDatas);
        return nodeDatas;
    }


    public static void encoding(HuffmanTreeNode huffmanTreeNode, Character c) {

        System.out.printf("\n%c   ",c);

        while (true) {

            if(huffmanTreeNode.getLeft()!=null){
                if(huffmanTreeNode.getLeft().getNodeData().getData().equals(c)){
                    System.out.print(0);
                    break;
                }
            }
            huffmanTreeNode = huffmanTreeNode.getRight();
            if(huffmanTreeNode.getLeft()==null&huffmanTreeNode.getRight()==null)
            {
                if(huffmanTreeNode.getNodeData().getData().equals(c)){
                    System.out.print("1");
                    break;
                }
            }
            System.out.print("1");
        }
    }


    public static void decoding(String coding ,HuffmanTreeNode huffmanTreeNode){

        ArrayList<Character> characters = new ArrayList<>();
        coding.chars().forEach(e->characters.add((char) e));


        for (Character character : characters) {
            if(character.equals('1')){
                huffmanTreeNode = huffmanTreeNode.getRight();
            }else {
                huffmanTreeNode = huffmanTreeNode.getLeft();
            }
        }
        System.out.println();
        System.out.println(huffmanTreeNode.getNodeData().getData());


    }



}