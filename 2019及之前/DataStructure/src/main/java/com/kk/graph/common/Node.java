package com.kk.graph.common;

import lombok.Data;

/**
 * @author KK
 * @create 2019-05-28 21:36
 * purpose: 基本元素节点
 * conclusion:
 **/
@Data
public class Node {

    private String name;

    public Node(String name) {
        this.name = name;

    }

    public boolean equals(Object obj) {
        return this.name.equals (((Node)obj).getName());
    }


}
