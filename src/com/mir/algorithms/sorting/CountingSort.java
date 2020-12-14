package com.mir.algorithms.sorting;

import java.util.Arrays;

public class CountingSort {


    public static void main(String[] args) {
        int[] intArr = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 } ;

        countingSort(intArr , 1 ,10);
        //Printing the array
//        for (int i : intArr) System.out.println(i);
    }

    public static void countingSort(int[] input, int min, int max){

        int[] countArray = new int[(max - min) + 1];

        for (int i = 0;  i < input.length ; i++){
            countArray[input[i] - min]++;

        }


        for (int i : countArray) System.out.println(i);

        int j=0;
        for (int i = min; i <= max; i++){
            while (countArray [i - min] > 0){
                input[j++] = i;
                countArray [i - min]--;
            }
        }

    }
}
