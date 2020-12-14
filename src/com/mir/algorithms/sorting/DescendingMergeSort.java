package com.mir.algorithms.sorting;

public class DescendingMergeSort {

    public static void main(String[] args) {
        int[] intArr = { 20, 35, -15, 7, 55, 1, -22, 25 ,-2 , 12 }  ;

        descMergeSort(intArr , 0 , intArr.length);
        //Print the array
        for (int i : intArr) System.out.println(i);
    }

    private static void descMergeSort(int[] intArr, int start, int end) {

        if (end - start < 2) return;

        int mid = (start + end) / 2;
        descMergeSort(intArr , start , mid);
        descMergeSort(intArr, mid, end);
        merge(intArr, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {

        /**
         * This is a optimized algorithm which means if the last element in the left partition
         * is greater than first element in the right partition then both the sides are already sorted
         * and there is no need of merging further
         */
        if (input[mid - 1] >= input[mid]) return;

        int i =  start;
        int j = mid;
        int tempIndex = 0;

        int[] tempArr = new int[end - start];

        while (i < mid && j < end){
            /**
             * here we compare right element with left and add smaller of the two to the temporary array
                    * the >= makes it a stable array
             */
            tempArr [tempIndex++] = input [i] >= input [j] ? input [i++] : input [j++];
        }

        System.arraycopy(input , i , input , start + tempIndex , mid - i);
        System.arraycopy(tempArr , 0 , input , start , tempIndex);


    }
}
