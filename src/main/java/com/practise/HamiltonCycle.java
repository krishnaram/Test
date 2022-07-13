package com.practise;

public class HamiltonCycle {

    /*
    1) Whether hamilton graph exists or not
    2) Find a path exists between 2 points or not
    3) Hamilton graph for given nodes
    4) Find all hamiltonian cycles
     */
    public static  void main(String[] arg){
        int graph[][] ={{0, 1, 0, 1, 0},
                        {1, 0, 1, 1, 1},
                        {0, 1, 0, 0, 1},
                        {1, 1, 0, 0, 1},
                        {0, 1, 1, 1, 0},
        };
        System.out.println("Printing all hamiltonian cycle");
    }

    public static String cycleExists(int[][] graph){
        int k =0;
        int[] path = new int[graph.length];
        do{

        }while(k<graph.length);
        return  "";
    }

    public static boolean findExistingInPath(int[][] graph, int[] path,int point){
        return false;
    }
}
