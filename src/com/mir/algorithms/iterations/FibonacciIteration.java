package com.mir.algorithms.iterations;

public class FibonacciIteration {

    private static void fibonacci(int n){

        int a = 0;
        int b = 1;

        int count = 1;
        while (count++ <= n){
            System.out.println(a);
            int temp = b;
            b = a +b;
            a = temp;
        }



    }

    public static void main(String[] args) {
        fibonacci(2);
    }
}
