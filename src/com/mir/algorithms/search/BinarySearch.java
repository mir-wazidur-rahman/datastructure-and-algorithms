package com.mir.algorithms.search;

public class BinarySearch {

    public static int find(int[] input, int item, int left, int right){

        //this is the search miss when the item is not present
        if(right < left) return -1 ;

        int middle = (left + right) / 2;

        // we find the item we are looking for
        if(input[middle] == item) return  middle;

        //we have to check if the item is in smaller or greater set
        if(input[middle] < item){
            //we can discard the left sub-array
            return find(input , item, middle+1, right);
        }else{
            //we can discard the right sub-array
            return find(input , item, left, middle-1);
        }

    }

    public static int findIterative(int[] input, int item, int left, int right){

        while (left <= right){
            int midIndex = right + left / 2;

            if(input[midIndex] == item) {
                return midIndex;
            }else if (input[midIndex] < item){
                //discard the left sub-array
                System.out.println("Int right sub array");
                left = midIndex + 1;
            }else {
                //discard the right sub-array
                System.out.println("Int left sub array");
                right = midIndex -1;
            }

        }
        return -1;

    }

    public static void main(String[] args) {

        int[] input = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(find(input, 10,0,input.length-1 ));
        System.out.println(findIterative(input, 10,0,input.length-1 ));
    }
}
