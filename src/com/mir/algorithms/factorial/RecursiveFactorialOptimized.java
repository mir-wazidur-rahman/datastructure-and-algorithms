package com.mir.algorithms.factorial;

public class RecursiveFactorialOptimized {

    private static long optimizedFact(long n, long result){

        if (n == 0) return result;

        System.out.println(result);
        return optimizedFact(n-1, n * result);
    }

    public static void main(String[] args) {

        System.out.println(optimizedFact(10 ,1));
//        optimizedFact(10 ,1);
    }
}
