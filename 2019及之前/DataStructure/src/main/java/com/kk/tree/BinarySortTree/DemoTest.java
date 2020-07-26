package com.kk.tree.BinarySortTree;

import java.util.Arrays;
import java.util.List;

/**
 * @author KK
 * @create 2019-06-03 22:04
 * purpose:
 * conclusion:
 **/
public class DemoTest {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(53,17,9,45,23,78,65,87);
        TreeNode root = BSTree.createBSTree(null, integers);
        BSTree.displayBSTree(root);
        System.out.println();
        BSTree.deleteKey(root,53);
        BSTree.displayBSTree(root);


        

    }
}
