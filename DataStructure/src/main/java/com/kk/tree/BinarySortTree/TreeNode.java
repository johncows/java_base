package com.kk.tree.BinarySortTree;

import lombok.Data;

/**
 * @author KK
 * @create 2019-06-03 21:43
 * purpose:
 * conclusion:
 **/
@Data
public class TreeNode {
    private Integer     key;
    private TreeNode lChild;
    private TreeNode rChild;

    public TreeNode(Integer key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                '}';
    }
}
