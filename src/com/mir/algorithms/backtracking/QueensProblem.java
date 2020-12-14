package com.mir.algorithms.backtracking;

public class QueensProblem {

    private final int[][] chesstable;
    private int numOfQueens;

    public QueensProblem(int numOfQueens){
        this.chesstable = new int[numOfQueens][numOfQueens];
        this.numOfQueens = numOfQueens;
    }

    public void solve(){

        if (setQueens(0)){
            printQueens();
        }else {
            System.out.println("There is no solution...");
        }
    }

    private boolean setQueens(int colIndex){

        //break condition
        if (colIndex == numOfQueens){
            return true;
        }

        for (int rowIndex=0; rowIndex < numOfQueens; ++rowIndex){

            if (isPlaceValid (rowIndex, colIndex)){
                chesstable[rowIndex][colIndex] = 1;

                if (setQueens(colIndex + 1)){
                    return true;
                }

                //BACKTRACKING
                chesstable[rowIndex][colIndex] = 0;

            }
        }

        return false;

    }

    private boolean isPlaceValid(int rowIndex, int colIndex){

        //this means there is a queen in the same row
        for (int i=0 ; i<colIndex ; i++)
            if (chesstable [rowIndex][i] == 1) return false;

        //diagonal check for top left to bottom right
        for(int i=rowIndex , j=colIndex ; i >= 0 && j >=0 ; i--,j--){
            if (chesstable[i][j] == 1)
                  return false;

        }

        //diagonal check for top right to bottom left
        for (int i=rowIndex, j=colIndex; i < chesstable.length && j >= 0; i++, j--){
            if(chesstable [i][j] == 1)
                return false;
        }

        return true;
    }

    private void printQueens(){
        for(int i=0 ; i< chesstable.length ; i++){
            for (int j=0; j< chesstable.length; j++){
                if (chesstable[i][j] == 1){
                    System.out.print(" * ");
                }else {
                    System.out.print(" - ");
                }
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {

        new QueensProblem(25).solve();
    }
}
