package com.mir.algorithms.backtracking;

public class KnightsTourProblem {

    private int[][] solutionMatrix;
    private int[] xMoves = {2,1,-1,-2,-2,-1,1,2};//up is positive , down is negative
    private int[] yMoves = {1,2,2,1,-1,-2,-2,-1};//right is positive and left is negative

    public KnightsTourProblem (){
        this.solutionMatrix = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        this.initializeBoard();
    }

    private void initializeBoard() {
        for (int i=0 ; i <  Constants.BOARD_SIZE ; i++)
            for(int j=0 ; j < Constants.BOARD_SIZE ; j++)
                solutionMatrix[i][j] = Integer.MIN_VALUE; //this means we have not visited the cell yet
    }

    public void solveTour() {

        solutionMatrix[0][0] = 0;//meaning we start from top left corner of the night tour

        if (solve(1,0,0)){
            printSolution();
        }else{
            System.out.println("No feasible solution");
            return;
        }
    }

    /**
     *
     * @param stepCount - Means the step in the chess boad
     * @param xCord
     * @param yCord
     * @return
     */
    private boolean solve(int stepCount, int xCord, int yCord) {

        //meaning we have traversed every single cell in the board
        if (stepCount == Constants.BOARD_SIZE * Constants.BOARD_SIZE ) {
            return true;
        }

        for(int i=0 ; i < Constants.NUM_OF_MOVES ; i++){
            //Here we are checking if it is possible to make next step with the move
            int nextX = xCord + xMoves[i];
            int nextY = yCord + yMoves[i];

            if (isStepValid (nextX,nextY)){
                solutionMatrix[nextX][nextY] = stepCount;

                //checking if it is possible to make the next move
                if ( solve (stepCount + 1,nextX,nextY) ){
                    return true;
                }

                //BACKTRACK - marking the cell as unvisited
                solutionMatrix[nextX][nextY] = Integer.MIN_VALUE;
            }
        }

        return false;
    }

    private boolean isStepValid(int xCord, int yCord) {

        if ( xCord < 0 || xCord >= Constants.BOARD_SIZE ) return false; //not going outside the board
        if ( yCord < 0 || yCord >= Constants.BOARD_SIZE ) return false; //not going outside the board
        if (solutionMatrix [xCord][yCord] != Integer.MIN_VALUE) return false; //cell is not already visited

        return true;
    }

    private void printSolution() {
        for (int i=0 ; i < Constants.BOARD_SIZE ; i++){
            for (int j=0 ; j < Constants.BOARD_SIZE ; j++) {
                System.out.print(solutionMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        new KnightsTourProblem().solveTour();
    }
}
