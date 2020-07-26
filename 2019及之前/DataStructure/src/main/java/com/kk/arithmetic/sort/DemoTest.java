package com.kk.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author KK
 * @create 2019-06-08 21:05
 * purpose:
 * conclusion:
 **/
public class DemoTest {
    //    2, 5, 7, 6, 9, 3, 8, 1, 4
    //    1,0,2,3,4,5,6,7,8,9
    public static void main(String[] args) {
//        ArrayList arrayList = new ArrayList<>(Arrays.asList(2, 5, 7, 6, 9, 3, 8, 1, 4));
//        SelectSort.sort01(arrayList);
//        System.out.println(arrayList);

       ArrayList arrayList = new ArrayList<>(Arrays.asList(2, 5, 7, 6, 9, 3, 8, 1, 4));
        int[] ints = {2, 5, 7, 6, 9, 3, 8, 1, 4};
        HeapSort.sortHeap(ints,ints.length);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }


}
