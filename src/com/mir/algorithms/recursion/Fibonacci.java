package com.mir.algorithms.recursion;

public class Fibonacci {

    private static int head (int n){

        //base base when n =0 return 0 when n=1 return
        if (n ==0) return 0;
        if (n ==1) return 1;

        //first we call the methods recursively
        int fib1 = head(n-1);
        int fib2 = head(n-2);

        //perform operations
        int result = fib1 + fib2;

        return result;

    }

    private static int tail (int n , int a , int b){

        //base base when n =0 return 0 when n=1 return
        if (n == 0) return a;
        if (n == 1) return b;

        System.out.println("n="+n +" a="+a +" b="+b );
        return tail(n-1 , b , a+b);
    }

    public static void main(String[] args) {

        System.out.println(head(6));
        System.out.println(tail(6,0,1));
    }
}
