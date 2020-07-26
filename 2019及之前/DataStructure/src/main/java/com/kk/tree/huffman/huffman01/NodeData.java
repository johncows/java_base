package com.kk.tree.huffman.huffman01;


import lombok.Data;

/**
 * @author KK
 * @create 2019-05-23 15:14
 **/
@Data
public class NodeData implements Comparable<NodeData> {

    public Integer weight;
    public Character data;

    public NodeData(Integer weight, Character data) {
        this.weight = weight;
        this.data = data;
    }


    @Override
    public int compareTo(NodeData o) {
        if(this.weight>o.weight){
            return 1;
        }
        return -1;
    }
}
