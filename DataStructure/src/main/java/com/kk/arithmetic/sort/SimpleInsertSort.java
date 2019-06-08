package com.kk.arithmetic.sort;

import java.util.List;

/**
 * @author KK
 * @create 2019-06-08 21:40
 * purpose:插入排序
 * conclusion:
 **/
public class SimpleInsertSort {


    public static void sort01(List<Integer> sortList) {
        int tempValue,j;
        for (int i = 1; i < sortList.size(); i++) {
            if (sortList.get(i - 1) > sortList.get(i)) {
                tempValue = sortList.get(i);
                for (j = i; j>0&&tempValue < sortList.get(j - 1); j--) {
                    sortList.set(j, sortList.get(j - 1));
                }
                sortList.set(j,tempValue);

            }
        }
    }
}