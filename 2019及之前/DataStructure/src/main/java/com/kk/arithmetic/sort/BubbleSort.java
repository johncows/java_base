package com.kk.arithmetic.sort;

import java.util.*;

/**
 * @author KK
 * @create 2019-06-08 20:14
 * purpose:冒泡排序两种表现方式
 * conclusion:
 **/
public class BubbleSort
{


    /**
     * 非冒泡排序 并不符合冒泡两两比较
     * @param sortList
     */
    public static void sort01(List<Integer> sortList){
        int size = sortList.size();
        int temp;
        int count01=0,count02=0;
        for (int i = 0;i<size;i++){
            for (int j = i;j<size;j++){
                count01++;
                if(sortList.get(i)>sortList.get(j)){
                    count02++;
                    temp = sortList.get(i);
                    sortList.set(i,sortList.get(j));
                    sortList.set(j,temp);
                }
            }
        }
        System.out.println("本次排序比较次数为 "+count01);
        System.out.println("本次排序交换次数为 "+count02);
    }

    /**
     * 标准冒泡 未进行优化 时间复杂度较高
     * @param sortList
     */
    public static void sort02(List<Integer> sortList){
        int size = sortList.size()-1;
        int temp;
        int count01=0,count02=0;
        for (int i = 0;i<size;i++){
            for (int j = 0;j<size-i;j++){
                count01++;
                if(sortList.get(j)>sortList.get(j+1)){
                    count02++;
                    temp = sortList.get(j+1);
                    sortList.set(j+1,sortList.get(j));
                    sortList.set(j,temp);
                }
            }
        }
        System.out.println("本次排序比较次数为 "+count01);
        System.out.println("本次排序交换次数为 "+count02);
    }


    /**
     * 优化版冒泡排序 当一趟冒泡下来 如果没有交换操作 直接突出循环
     * @param sortList
     */
    public static void sort03(List<Integer> sortList){
        int size = sortList.size()-1;
        int temp;
        int count01=0,count02=0;
        boolean flag = true;
        for (int i = 0;i<size&&flag==true;i++){
            flag = false;
            for (int j = 0;j<size-i;j++){
                count01++;
                if(sortList.get(j)>sortList.get(j+1)){
                    count02++;
                    temp = sortList.get(j+1);
                    sortList.set(j+1,sortList.get(j));
                    sortList.set(j,temp);
                    flag = true;
                }
            }
        }
        System.out.println("本次排序比较次数为 "+count01);
        System.out.println("本次排序交换次数为 "+count02);
    }
}
