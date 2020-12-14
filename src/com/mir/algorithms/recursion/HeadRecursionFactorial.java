package com.mir.algorithms.recursion;

public class HeadRecursionFactorial {

    public static int head(int n){

        //base case when n = 0
        if (n == 0) return 1;

        int res1 = head(n-1);
        int result = n * res1;

        return result;
    }

    public static void main(String[] args) {

        System.out.println(head(6));
    }
}
