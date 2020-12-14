package com.mir.algorithms.commonproblems;

public class KadaneAlgorithm {

    private static int solve(int[] inputArray){

        int max_global = inputArray[0];
        int max_current = inputArray[0];

        for (int i=1 ; i < inputArray.length ; i++){
            max_current = Math.max(inputArray[i],max_current + inputArray[i]);

            max_global = max_current > max_global ? max_current : max_global;
        }

        return max_global;

    }

    public static void main(String[] args) {

        int[] input = {1,-2,3,4,-5,8};
        System.out.println(solve(input));
    }
}
