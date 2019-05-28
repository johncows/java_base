package com.kk.tree.graph.undirected_graph;

import com.kk.tree.graph.common.Node;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KK
 * @create 2019-05-28 21:36
 * purpose: 无向图
 * conclusion:
 **/
@Data
public class  UndirectedGraph {

    public final static int MAX_VALUE = -1;

    private ArrayList<Node> nodeList = new ArrayList<>();
    int arcNum,nodeNum;
    private int[][] graph;


    public UndirectedGraph(List<Node> s ){
        nodeNum = s.size();
        init(nodeNum);

        for (Node node : s) {
            nodeList.add(node);
        }

    }

    public void addLink(Node from,Node to , Integer weight){
        int i = nodeList.indexOf(from);
        int j = nodeList.indexOf(to);

        if(i ==-1 || j==-1){
            System.err.println("无法添加边");
            return ;
        }
        arcNum++;
        graph[i][j] =graph[j][i]= weight;

    }



    private void init(int num){
        graph = new int[num][num];
        for(int i= 0;i<num;i++){
            for(int j=0;j<num;j++){
                graph[i][j] = MAX_VALUE;
            }
        }
        for(int i = 0;i<num;i++){
            graph[i][i] =0;
        }
    }


    public void show(){
        System.out.println("节点如下");
        System.out.println("-----------------------------");
        for (Node node : nodeList) {
            System.out.print(node.getName()+" ");
        }
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("边个数为"+arcNum);
        System.out.println("-----------------------------");
        System.out.println();
        for(int i= 0;i<nodeNum;i++){
            for(int j=0;j<nodeNum;j++){
                System.out.printf("%3d",graph[i][j]);
            }
            System.out.println();
        }


    }











}
