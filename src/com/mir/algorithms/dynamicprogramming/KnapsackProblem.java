package com.mir.algorithms.dynamicprogramming;

public class KnapsackProblem {

    private int numOfItems;
    private int capacityOfKnapsack;
    private int[][] knapsackTable;
    private int totalBenefit;
    private int[] weights;
    private int[] values;

    private KnapsackProblem(int numOfItems, int capacityOfKnapsack, int[] weights, int[] values){
        this.numOfItems = numOfItems;
        this.capacityOfKnapsack = capacityOfKnapsack;
        this.weights = weights;
        this.values = values;
        this.knapsackTable = new int[numOfItems + 1][capacityOfKnapsack + 1];

    }

    public void solve(){

        for (int i = 1; i < numOfItems+1 ; i++){
            for (int w=1 ; w < capacityOfKnapsack+1 ; w++){
                int notTakingItem = knapsackTable[i-1][w]; // not taking the item i

                int takingItem = 0;

                if (weights[i] <= w){
                    takingItem = values[i] + knapsackTable[i-1][w-weights[i]];
                }
//                System.out.println("notTakingItem:" + notTakingItem + ", takingItem:" + takingItem);
                knapsackTable[i][w] = Math.max(notTakingItem,takingItem);
            }
        }

        totalBenefit = knapsackTable[numOfItems][capacityOfKnapsack];
    }

    public void showResult(){

//        for (int i = 0; i < numOfItems + 1; i++) {
//            for(int j=0;j < capacityOfKnapsack +1; j++){
//                System.out.print(knapsackTable[i][j]);
//            }
//            System.out.println();
//
//        }


        System.out.println("Total benefit :: " + totalBenefit);

        for(int n=numOfItems , w = capacityOfKnapsack; n > 0; n--){
            if (knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n-1][w]){
                System.out.println("We take item: #"+n);
                w = w - weights[n];
            }
        }
    }

    public static void main(String[] args) {


        int numOfItems = 3;
        int capacityOfKnapsack = 5;

        // int[] weightOfItems = {4,2,3};
        // int[] profitOfItems = {10,4,7};

        int[] weightOfItems = new int[numOfItems + 1];
        weightOfItems[1] = 4;
        weightOfItems[2] = 2;
        weightOfItems[3] = 3;

        int[] profitOfItems = new int[numOfItems + 1];
        profitOfItems[1] = 10;
        profitOfItems[2] = 4;
        profitOfItems[3] = 7;

        KnapsackProblem knapsack = new KnapsackProblem(numOfItems, capacityOfKnapsack, weightOfItems, profitOfItems);
        knapsack.solve();
        knapsack.showResult();
    }
}
