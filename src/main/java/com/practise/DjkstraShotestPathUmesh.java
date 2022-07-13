package com.practise;

public class DjkstraShotestPathUmesh {

     static int[] dijkstra(int graph[][], int src) {

         int totalVertices = graph[0].length;
         int dist[] = new int[graph[0].length]; // The output array. dist[i] will hold
         // the shortest distance from src to i

         // sptSet[i] will true if vertex i is included in shortest
         // path tree or shortest distance from src to i is finalized
         Boolean sptSet[] = new Boolean[totalVertices];

         // Initialize all distances as INFINITE and stpSet[] as false
         for (int i = 0; i < totalVertices; i++) {
             dist[i] = Integer.MAX_VALUE;
             sptSet[i] = false;
         }

         // Distance of source vertex from itself is always 0
         dist[src] = 0;

         // Find shortest path for all vertices
         for (int count = 0; count < totalVertices - 1; count++) {
             // Pick the minimum distance vertex from the set of vertices
             // not yet processed. u is always equal to src in first
             // iteration.
             int u = minDistance(dist, sptSet, totalVertices);

             // Mark the picked vertex as processed
             sptSet[u] = true;

             // Update dist value of the adjacent vertices of the
             // picked vertex.
             for (int v = 0; v < totalVertices; v++)

                 // Update dist[v] only if is not in sptSet, there is an
                 // edge from u to v, and total weight of path from src to
                 // v through u is smaller than current value of dist[v]
                 if (!sptSet[v] && graph[u][v] != 0 &&
                         dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                     dist[v] = dist[u] + graph[u][v];
         }
         return  dist;
     }

    static int minDistance(int dist[], Boolean sptSet[], int totalVertices)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < totalVertices; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }
    public static void main(String[] args)
    {
        String nodes[] ={"A","B","C","D","E","F","G","H"};
        int src =0 ;// For a
         int[][] graph = {
                //A,B,C,D,E,F,G,H
                 {0,1,1,0,0,0,0,0},//A
                 {1,0,0,1,0,0,0,0},//B
                 {1,1,0,1,0,0,0,0},//C
                 {0,1,1,0,1,0,0,0},//D
                 {0,0,0,1,0,0,0,1},//E
                 {0,0,0,0,0,0,1,0},//F
                 {0,0,0,0,0,1,0,0},//G
                 {0,0,0,0,1,0,0,0}};//H

        int[] dist = dijkstra(graph, src);
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < graph[0].length; i++)
            if(i != src){
                if(dist[i] != Integer.MAX_VALUE){
                    System.out.println(nodes[i] + " " + dist[i]);
                }
                else
                    System.out.println(nodes[i] + " INF");
            }
    }
}
