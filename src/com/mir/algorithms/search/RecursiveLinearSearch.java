package com.mir.algorithms.search;

public class RecursiveLinearSearch {

    private static int search(int[] input, int item , int index){

        //base condition
        if (index >= input.length) return -1;

        if (input[index] == item) return index;

        return search(input , item , index+1);
    }

    public static void main(String[] args) {

        int[] input = {1,5,-5,3,2,15};
        System.out.println(search(input, 5, 0));
    }
}
