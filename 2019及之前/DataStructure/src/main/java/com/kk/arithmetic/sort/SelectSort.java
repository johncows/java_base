package com.kk.arithmetic.sort;

import java.util.List;

/**
 * @author KK
 * @create 2019-06-08 20:47
 * purpose:选择排序
 * conclusion:
 **/
public class SelectSort {

    public static void sort01(List<Integer> sortList){

      int MINVALUE,tempIndex ;
      int count01=0,count02=0;

      for (int i = 0;i<sortList.size();i++){
          MINVALUE = sortList.get(i);
          tempIndex =i;
          for(int j = i+1;j<sortList.size();j++){
              count01++;
              if(MINVALUE >sortList.get(j)){
                  MINVALUE = sortList.get(j);
                  tempIndex = j;
              }
          }
          if(i != tempIndex){
              count02++;
              sortList.set(tempIndex,sortList.get(i));
              sortList.set(i,MINVALUE);
          }
      }
        System.out.println("本次排序比较次数为 "+count01);
        System.out.println("本次排序交换次数为 "+count02);
    }


}
