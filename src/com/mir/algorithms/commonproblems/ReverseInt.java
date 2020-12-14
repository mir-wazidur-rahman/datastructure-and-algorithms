package com.mir.algorithms.commonproblems;

public class ReverseInt {

    public static int reverseInt(int n){

        int newInt = 0;

        while (n != 0){
            newInt = (newInt*10) + (n%10);
            n = n / 10;
        }

        return newInt;

    }

    public static void main(String[] args) {

        int n = 1234;

        System.out.println("Original num ::" +n);
        System.out.println("Reversed num ::"+reverseInt(n));
    }
}
