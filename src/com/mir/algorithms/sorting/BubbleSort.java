package com.mir.algorithms.sorting;

public class BubbleSort {

    public static void main(String[] args) {

        int[] intArr = {20, 35, -15, 7, 55, 1, -22} ;

        for (int firstIndex=0;firstIndex < intArr.length ; firstIndex++){
            for (int nextIndex=firstIndex;nextIndex>0;nextIndex--){
                if (intArr[nextIndex] < intArr[nextIndex-1]) swap(intArr,nextIndex,nextIndex-1);
            }
        }

        for (int i : intArr) System.out.println(i);


    }

    public static void swap(int[] array,int i, int j){

        if (i == j) return;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
