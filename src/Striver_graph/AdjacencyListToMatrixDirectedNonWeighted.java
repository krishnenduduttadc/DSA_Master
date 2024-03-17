package Striver_graph;

import java.util.ArrayList;

public class AdjacencyListToMatrixDirectedNonWeighted {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(3);
        adj.get(1).add(2);
        adj.get(3).add(4);
        adj.get(4).add(5);

        int[][] adjacencyMatrix = convertToAdjacencyMatrix(adj, V);
        for (int i = 0; i <= V; i++) {
            for (int j = 0; j <= V; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] convertToAdjacencyMatrix(ArrayList<ArrayList<Integer>> adj, int V) {
        int[][] adjacencyMatrix = new int[V + 1][V + 1];
        for (int i = 0; i <=V ; i++) {
            for(int j:adj.get(i)){
                adjacencyMatrix[i][j]=1;
            }
        }
        return adjacencyMatrix;
    }
}
