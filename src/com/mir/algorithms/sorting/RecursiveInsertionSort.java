package com.mir.algorithms.sorting;

public class RecursiveInsertionSort {

    public static void main(String[] args) {

        int[] intArr = { 20, 35, -15, 7, 55, 1, -22 } ;

        insertionSort(intArr, intArr.length);
        //Print the array
        for (int i : intArr) System.out.println(i);
    }

    public static void insertionSort(int[] input , int numItems){

        if (numItems < 2) return;

        insertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];


        int i;

        for (i = numItems - 1 ; i > 0 && input [i - 1] > newElement;  i--) input[i] = input[i - 1];

        input[i] = newElement;
        System.out.println("Result of call when numItems = " + numItems);
        for (int j : input){
            System.out.print(j);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("------------------");

    }
}
