package com.kk.arithmetic.sort;



/**
 * @author KK
 * @create 2019-06-09 9:21
 * purpose:希尔排序(缩小增量)
 * conclusion:
 **/
public class ShellSort {

    public static void sort01(int[] sortList){

        int length = sortList.length;
        int gap,temp,j;

        for(gap = length/2; gap>=1;gap/=2){
            for (int i = gap ; i< sortList.length;i++){
                if(sortList[i]<sortList[i-gap]){
                   temp = sortList[i];
                   for (j = i;j-gap>=0&&sortList[j-gap]>temp;j-=gap){
                       sortList[j] = sortList[j-gap];
                   }
                   sortList[j] = temp;
                }
            }
        }



    }



}
