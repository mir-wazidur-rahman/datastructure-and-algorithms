package com.mir.algorithms.backtracking;

/**
 * Vertex coloring is the most common problem !!!
 * 	- The problem is, given m colors, find a way of coloring the vertices of a graph such that no two adjacent vertices are colored using same color
 *  - CHROMATIC NUMBER: The smallest number of colors needed to color a graph G is called its chromatic number
 *  - The problem to find chromatic number of a given graph is NP Complete
 *
 *  	Several applications:
 *
 *  		1.) Making schedules // time tables
 *
 *  				Suppose we want to make am exam schedule for a university. We have list different subjects and students enrolled in
 *  		    	every subject. Many subjects would have common students (of same batch, some backlog students, etc). How do we schedule
 *  	        	the exam so that no two exams with a common student are scheduled at same time? How many minimum time slots are needed to
 *  		    	schedule all exams? This problem can be represented as a graph where every vertex is a subject and an edge between two vertices
 *  		    	mean there is a common student. So this is a graph coloring problem where minimum number of time slots is equal to the chromatic
 *  		    	number of the graph.
 *
 *  		2.) Mobile Radio Frequency Assignment
 *
 *  			 	When frequencies are assigned to towers, frequencies assigned to all towers at the same location must be different. How
 *  			    to assign frequencies with this constraint? What is the minimum number of frequencies needed? This problem is also an
 *  				instance of graph coloring problem where every tower represents a vertex and an edge between two towers represents
 *  				that they are in range of each other
 *
 *  		3.) Map coloring
 *
 *  				Geographical maps of countries or states where no two adjacent cities cannot be assigned same color.
 *  				Four colors are sufficient to color any map
 *
 *  		4.) Register Allocation
 *
 *  				In compiler optimization, register allocation is the process of assigning a large number of target program
 *  				variables onto a small number of CPU registers. This problem is also a graph coloring problem
 *
 * 	Here we implement the greedy algorithm: d+1 colort hasznal max -> d a legtobb fogszammal rendelkezo vertex eleinek szama
 * 			 It doesn’t guarantee to use minimum colors, but it guarantees an upper bound on the number of colors !!!
 *
 */
public class GraphColoring {

    private int numOfVertices;
    private int numOfColors;
    private int[] colors;
    private int[][] adjacencyMatrix;

    public GraphColoring(int[][] adjacencyMatrix, int numOfColors){
        this.numOfColors = numOfColors;
        this.adjacencyMatrix = adjacencyMatrix;
        this.numOfVertices = adjacencyMatrix.length;
        this.colors = new int[numOfVertices];
    }

    public void solve(){

        if (solveProblem(0)){
            showResults();
        }else{
            System.out.println("No solutions...");
        }
    }

    private boolean solveProblem(int nodeIndex) {

        //we have covered all nodes
        if (nodeIndex == numOfVertices){
            return true;
        }

        for (int colorIndex=1 ; colorIndex <= numOfColors ; colorIndex++){

            if (isColorValid(nodeIndex,colorIndex)){
               colors[nodeIndex] = colorIndex; //assign color to node

                //checking the solution for next node
                if (solveProblem(nodeIndex + 1)){
                    return true;
                }

                //BACKTRACK!!!
            }
        }

        return false;
    }

    private boolean isColorValid(int nodeIndex, int colorIndex) {

        for (int i=0 ; i < numOfVertices ; i++)
            if (adjacencyMatrix[nodeIndex][i] == 1 && colorIndex == colors[i])
                return false;


        return true;
    }

    private void showResults(){
        for (int i=0 ; i < numOfVertices ; i++)
            System.out.println("Node " + (i+1) + " has " + colors[i]);
    }

    public static void main(String[] args) {

        int[][] graphMatrix = new int[][]{
                {0,1,0,1,0},
                {1,0,1,1,0},
                {0,1,0,1,0},
                {1,1,1,0,1},
                {0,0,0,1,0}
        };
        int numOfColors = 3;

        new GraphColoring(graphMatrix,numOfColors).solve();
    }
}
