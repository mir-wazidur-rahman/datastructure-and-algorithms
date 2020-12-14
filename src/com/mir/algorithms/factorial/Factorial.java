package com.mir.algorithms.factorial;

public class Factorial {



    public static void main(String[] args) {

        System.out.println("recursiveFactorial :: " + recursiveFactorial(30));
        System.out.println("iterativeFactorial :: " + iterativeFactorial(30));
    }

    public static long recursiveFactorial(long num){

        if (num == 0) return 1;

        return num * recursiveFactorial(num-1);
    }

    public static long iterativeFactorial(long num){

        if (num == 0) return 1;

        long factorial = 1;

        for(long i=1 ; i<= num ; i++) factorial *= i;

        return factorial;

    }
}
