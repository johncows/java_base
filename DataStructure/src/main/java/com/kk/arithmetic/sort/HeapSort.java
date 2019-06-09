package com.kk.arithmetic.sort;

/**
 * @author KK
 * @create 2019-06-09 16:50
 * purpose: 堆排序
 * conclusion:
 **/
public class HeapSort{


    public static void swap(int[] tree, int a ,int b){
        int temp = tree[a];
        tree[a] = tree[b];
        tree[b] = temp;
    }


    public static void heapify(int[] tree, int len ,int point){

        if(point>len){
            return;
        }

        int c1 = point*2+1;
        int c2 = point*2+2;
        int max = point;

        if(c1<len && tree[c1] > tree[max])
            max =c1;
        if(c2<len && tree[c2] > tree[max])
            max =c2;
        if(max != point){
            swap(tree,max,point);
            heapify(tree,len,max);
        }

    }


    public static void createHeap(int[] tree,int length){
        for(int i = length/2 - 1;i>=0;--i){
            heapify(tree,length,i);
        }
    }


    public static void sortHeap(int[] tree,int n){
        createHeap(tree,n);
        for(int i=n-1; i>0;i--){
            swap(tree,0,i);
            heapify(tree,i,0);
        }
    }


}
