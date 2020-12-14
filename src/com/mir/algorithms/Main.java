package com.mir.algorithms;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int [] intArray = new int[7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = -111;
        intArray[6] = -22;

        Arrays.parallelSort(intArray);

        for (int i : intArray){
            System.out.println(i);

        }
    }
}
