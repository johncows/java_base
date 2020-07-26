package com.kk.tree.BinarySortTree;


import sun.reflect.generics.tree.Tree;

import java.util.Iterator;
import java.util.List;

/**
 * @author KK
 * @create 2019-06-03 21:44
 * purpose:  二叉排序树的功能实现
 * conclusion:
 **/
public class BSTree {



    public static void deleteKey(TreeNode treeNode , Integer key){
        /*
        1.找到需要删除的结点
        2.判断该节点的左右情况
        3.右边为空 左子树顶上左边为空 右子树顶上
        4.左右都不会空 递归左子树的最大值 将数据拷贝到删除节点处 再删除最大值所在的节点
        5.左右都为空 删了就删了
     */
        fatherNode = treeNode;
        TreeNode deleteKey = findKey(treeNode, key);
        if(deleteKey==null) return ;
        boolean isLeft = fatherNode.getKey()>key? true: false;

//        针对叶子节点
        if(deleteKey.getLChild()==null&&deleteKey.getRChild()==null){
            if(isLeft)
                fatherNode.setLChild(null);
            else
                fatherNode.setRChild(null);
        }else if(deleteKey.getLChild()==null){
            if(isLeft)
                fatherNode.setLChild(deleteKey.getRChild());
            else
                fatherNode.setRChild(deleteKey.getRChild());
        }else if(deleteKey.getRChild()==null){
            if(isLeft)
                fatherNode.setLChild(deleteKey.getLChild());
            else
                fatherNode.setRChild(deleteKey.getLChild());
        }else{
            TreeNode maxNode = findMaxNode(deleteKey.getLChild());
            leftTreeMaxNodeFather = deleteKey;
            deleteKey.setKey(maxNode.getKey());
            leftTreeMaxNodeFather.setLChild(null);
        }
    }


    //辅助删除操作的字段及方法
    private static TreeNode fatherNode = null;
    private static TreeNode leftTreeMaxNodeFather = null;
    private static  TreeNode  findMaxNode(TreeNode treeNode ){
        if(treeNode.getRChild()==null)
            return treeNode;
        leftTreeMaxNodeFather = treeNode;
        return findMaxNode(treeNode.getRChild());
    }

    private static  TreeNode findKey(TreeNode treeNode , Integer key) {
        if(treeNode == null||treeNode.getKey().equals(key)){
            return treeNode;
        }else if(treeNode.getKey()>key){
            fatherNode = treeNode;
            return findKey(treeNode.getLChild() ,key);
        }else {
            fatherNode = treeNode;
            return findKey(treeNode.getRChild(), key);
        }

    }



//  查询key
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

//    初始化一颗二叉排序树 需传入key
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
