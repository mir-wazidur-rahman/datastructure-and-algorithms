package com.mir.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private Map<Integer,Integer> memoizeTable;

    public Fibonacci(){
        //intialise memoize table and put the base values
        this.memoizeTable = new HashMap<>();
        this.memoizeTable.put(0, 0);
        this.memoizeTable.put(1, 1);

    }

    public int fibonacciDP(int n){

        //O(1)
        if (memoizeTable.containsKey(n)) return memoizeTable.get(n);

        memoizeTable.put(n-1 ,fibonacciDP(n-1));
        memoizeTable.put(n-2 ,fibonacciDP(n-2));

        int calculatedNum = memoizeTable.get(n-1) + memoizeTable.get(n-2);

        //pushing the result into a table for the number n
        memoizeTable.put(n,calculatedNum);

        return calculatedNum;
    }

    //it has exponential running time
    public static int naiveFibonacci (int n){

        if (n == 0) return 0;
        if (n == 1) return 1;

        return naiveFibonacci(n-1) + naiveFibonacci(n-2);

    }

    public static void main(String[] args) {

//        System.out.println("Naive Fibonacci :: " + naiveFibonacci(1000));
        System.out.println("Dynamic Fibonacci :: " + new Fibonacci().fibonacciDP(1000));
    }
}
