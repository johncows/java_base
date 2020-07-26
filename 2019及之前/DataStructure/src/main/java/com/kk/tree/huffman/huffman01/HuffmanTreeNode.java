package com.kk.tree.huffman.huffman01;

import lombok.Data;

/**
 * @author KK
 * @create 2019-05-21 21:38
 *
 * 描述 哈夫曼树节点
 * 参数
 *      左右子树的引用
 *      权值
 *
 **/
@Data
public class HuffmanTreeNode {

//    左子树
    private HuffmanTreeNode left;

//    右子树
    private HuffmanTreeNode right;

//     节点数据
    private NodeData nodeData;


//    构造一个哈夫曼树节点
    public static HuffmanTreeNode createHuffmanTreeNode(NodeData nodeData){
        HuffmanTreeNode huffmanTreeNode = new HuffmanTreeNode();
        huffmanTreeNode.nodeData = nodeData;
        return huffmanTreeNode;
    }



}
