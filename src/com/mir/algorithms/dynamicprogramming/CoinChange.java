package com.mir.algorithms.dynamicprogramming;

public class CoinChange {

    //recursive coin change : O(2^N)
    public static int naiveCoinChange(int M, int[] v, int index){

        if (M < 0) return 0;
        if (M == 0) return 1;

        //we have traversed through all the coins
        if (v.length == index) return 0;

        return naiveCoinChange(M-v[index] , v,index) + naiveCoinChange(M,v,index+1);
    }

    public static void dynamicProgrammingCoinChange(int[] v, int M){

        int[][] dpTable = new int[v.length+1][M+1];

        //setting first column as 1
        for(int i=0;i<=v.length;i++) dpTable[i][0] = 1;

        //setting first row as 0
        for (int i=1; i<= M ; i++) dpTable[0][i] = 0;

        for(int i=1 ; i <= v.length ; i++){
            for(int j=1; j <= M ; j++){

                //taking the coin
                if (v[i-1] <= j){
                    dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-v[i-1]];
                }else{
                    dpTable[i][j] = dpTable[i-1][j];
                }
            }
        }
        System.out.println("Solution :: " + dpTable[v.length][M]);
    }

    public static void main(String[] args) {

        int[] v = {1,2,3,4,5};
        int M = 40;
//        System.out.println(naiveCoinChange(M,v,0));
        dynamicProgrammingCoinChange(v,M);
    }

}
