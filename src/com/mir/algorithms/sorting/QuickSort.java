package com.mir.algorithms.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] intArr = { 20, 35, -15, 7, 55, 1, -22 } ;

        quickSort(intArr , 0 , intArr.length);
        //Print the array
        for (int i : intArr) System.out.println(i);
    }

    public static void quickSort(int[] input, int start, int end){

        if (end - start < 2) return;

        int pivotIndex = partition (input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    private static int partition(int[] input, int start, int end) {

        //this is using the first element in the pivots
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j){


            /**
             * NOTE: This is an empty loop to find an element less than the pivot to be used in the next step
             * to copy into the array
             */
            while (i < j && input [--j] >= pivot);

            if (i < j) input [i] = input [j];


            /**
             * NOTE: This is an empty loop to find an element greater than the pivot to be used in the next step
             * to copy into the array
             */
            while (i < j && input [++i] <= pivot);

            if (i < j) input [j] = input [i];

        }
        input [j] = pivot;

        //returning the index where we inserted the pivot
        return j;
    }


}
