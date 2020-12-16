package com.mir.algorithms.hashtables;

import java.util.*;

public class BucketSort {

    private static void bucketSort(int[] input){
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length ; i++){
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < input.length ; i++){
            buckets[hash(input[i])].add(input[i]);
        }

        for (List bucket : buckets){
            Collections.sort(bucket);
        }

        int j=0;
        for (int i=0 ; i < buckets.length ; i++){
            for (int value: buckets[i]){
                input[j++] = value;
            }
        }

    }

    private static int hash(int value){
        return value / (int) 10 % 10; // division takes precedence over mod hence division will be done first then the result will be moded
    }
    public static void main(String[] args) {

        int[] inputArray = {54, 46, 83, 66, 95, 92, 43};

        bucketSort(inputArray);

        for (int i = 0; i < inputArray.length; i++)
            System.out.println(inputArray[i]);

    }


}
