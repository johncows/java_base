package com.kk.tree.BinarySortTree;


import java.util.Iterator;
import java.util.List;

/**
 * @author KK
 * @create 2019-06-03 21:44
 * purpose:
 * conclusion:
 **/
public class BSTree {


    public static TreeNode queryKey(TreeNode treeNode , Integer key) {
        if(treeNode == null||treeNode.getKey().equals(key)){
            return treeNode;
        }else if(treeNode.getKey()>key){
            return queryKey(treeNode.getLChild() ,key);
        }else {
            return queryKey(treeNode.getRChild(), key);
        }

    }




//    添加单独key
    public static void insertKey(TreeNode treeNode , Integer key) {
        if (key < treeNode.getKey()) {
            if (treeNode.getLChild() == null) {
                TreeNode temp = new TreeNode(key);
                treeNode.setLChild(temp);
            } else {
                insertKey(treeNode.getLChild(), key);
            }
        } else if (key > treeNode.getKey()){
            if (treeNode.getRChild() == null) {
                TreeNode temp = new TreeNode(key);
                treeNode.setRChild(temp);
            } else {
                insertKey(treeNode.getRChild(), key);
            }
        }
    }

//    初始化一颗二叉排序树
    public static TreeNode createBSTree(TreeNode treeNode, List<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        if (treeNode==null){
            treeNode = new TreeNode(iterator.next());
        }

        while (iterator.hasNext()){
            insertKey(treeNode , iterator.next());
        }
        return treeNode;
    }


//  中序遍历二叉树
    public static void displayBSTree(TreeNode treeNode ){
        if(treeNode == null)
            return;
        displayBSTree(treeNode.getLChild());
        System.out.print(treeNode.getKey()+" ");
        displayBSTree(treeNode.getRChild());
    }
}
