package com.mir.algorithms.search;

public class LinearSearchIterative {

    private static int find(int[] arr, int item){

        //runtime O(n)
        for(int i=0; i<arr.length ; i++) {
            if (arr[i] == item){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] input = {1,5,-5,3,2,15};
        System.out.println(find(input,-5));
    }
}
