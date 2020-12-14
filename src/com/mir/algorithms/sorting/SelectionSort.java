package com.mir.algorithms.sorting;

public class SelectionSort {

    public static void main(String[] args) {

        int[] intArr = {20, 35, -15, 7, 55, 1, -12} ;

        for (int lastUnsortedIndex = intArr.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--){

            int largestIndex = 0;

            for (int i = 1 ; i <= lastUnsortedIndex ; i++) {
                if (intArr[i] > intArr[largestIndex]) {
                    largestIndex = i;
                }
            }


            swap(intArr, largestIndex , lastUnsortedIndex);
        }

        //Print the array
        for (int i : intArr) System.out.println(i);
    }


    public static void swap(int[] array,int i, int j){

        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
