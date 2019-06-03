package com.kk.tree.BinarySortTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author KK
 * @create 2019-06-03 22:04
 * purpose:
 * conclusion:
 **/
public class DemoTest {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(12, 14, 21, 45, 23, 96);
        TreeNode root = BSTree.createBSTree(null, integers);
        BSTree.displayBSTree(root);
        System.out.println();
        TreeNode treeNode = BSTree.queryKey(root, 92);

        System.out.println("treeNode = " + treeNode);

    }
}
