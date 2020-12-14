package com.mir.algorithms.backtracking;

public class HamiltonianCycle {

    private int numOfVertices;
    private int[] hamiltonianPath;
    private int[][] adjacencyMatrix;

    public HamiltonianCycle (int[][] adjacencyMatrix){
        this.adjacencyMatrix = adjacencyMatrix;
        this.hamiltonianPath = new int[adjacencyMatrix.length];
        this.numOfVertices = adjacencyMatrix.length;

        this.hamiltonianPath[0] = 0;

        if (findFeasibleSolution(1)){
            showHamiltonianPath();
        }else{
            System.out.println("No feasible solution...");
        }
    }

    private boolean findFeasibleSolution(int position) {

        if(position == numOfVertices){
            //check if the Hamiltonian path exists i.e if the last vertex in the path is connected to first one
            if( adjacencyMatrix[hamiltonianPath[position-1]][hamiltonianPath[0]] == 1){
                return true;
            }else{
                return false;
            }
        }

        //check path for rest of the vertices
        for (int vertexIndex = 1 ; vertexIndex < numOfVertices ; vertexIndex++){

            //if it is feasible to traverse to current path from the position
            if (isFeasible(vertexIndex,position)){
                hamiltonianPath[position] = vertexIndex;

                //calling next solution recursively
                if (findFeasibleSolution(position + 1)){
                    return true;
                }

                //BACKTRACK !!!

            }
        }



        return false;
    }

    private boolean isFeasible(int vertexIndex, int actualPosition) {

        //first check if two nodes are connected?
        if (adjacencyMatrix[hamiltonianPath[actualPosition-1]][vertexIndex] == 0){//no connection
            return false;
        }

        // check if we have already traversed the path?
        for (int i=0 ; i <  actualPosition ; i++)
            if (hamiltonianPath[i] == vertexIndex)
                return false;

        return true;
    }

    private void showHamiltonianPath(){

        System.out.println("Hamiltonian cycle: ");

        for (int i=0; i < hamiltonianPath.length ; i++){
            System.out.println(hamiltonianPath[i] + " ");
        }
    }


    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        new HamiltonianCycle(matrix);
    }
}
