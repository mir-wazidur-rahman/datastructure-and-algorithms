package com.mir.algorithms.recursion;

public class RecursionExample {

    public static void headRecusrsion(int n){

        //base case
        if (n == 0) return;

        System.out.println("Calling the head function with n=" + n);
        headRecusrsion(n-1);

        // do some operations
        System.out.println("The value of n = " + n);
    }

    public static void tailRecursion(int n){

        System.out.println("Calling the tail function with n=" + n);

        //base case
        if (n == 0) return;

        //do some operations
        System.out.println("The value of n = " + n);

         tailRecursion(n-1);
    }

    public static void main(String[] args) {

        headRecusrsion(5);

        tailRecursion(5);
    }


}

