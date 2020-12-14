package com.mir.algorithms.abstractdatatypes.lists;

import java.util.*;

public class ArrayListTest {

    public static void main(String[] args) {
        Integer[] arrival = {1, 2, 12, 5, 6, 30, 32, 7};
        Integer[] load = {15, 10, 10, 10, 10, 15, 10};
        List<Integer> arrivalList = Arrays.asList(arrival);


        List<Integer> loadcpy = Arrays.asList(load);
        ArrayList<Integer> sortedList = new ArrayList<>(loadcpy);
        Collections.sort(loadcpy, new Comparator<Integer>() {
            public int compare(Integer left, Integer right) {
                return Integer.compare(arrivalList.indexOf(left), arrivalList.indexOf(right));
            }
        });


//       Arrays.sort(arrival);
        for (Integer i : loadcpy) System.out.println(i);
    }
}
