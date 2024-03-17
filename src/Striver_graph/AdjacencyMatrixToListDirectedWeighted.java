package Striver_graph;

import java.util.ArrayList;

public class AdjacencyMatrixToListDirectedWeighted {
    static class Edge {
        int d;
        int wt;

        Edge(int d, int wt) {
            this.d = d;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int[][] adjmat = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 2, 3, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 0}
        };

        ArrayList<ArrayList<Edge>> weightedAdjacencyList = convertToWeightedAdjacencyList(adjmat);
        for (int i = 1; i < weightedAdjacencyList.size(); i++) {
            System.out.print(i + ": ");
            for (Edge edge : weightedAdjacencyList.get(i)) {
                System.out.print("(" + edge.d + ", " + edge.wt + ") ");
            }
            System.out.println();
        }
    }


    public static ArrayList<ArrayList<Edge>> convertToWeightedAdjacencyList(int[][] adjmat) {
        int V = adjmat.length - 1; // Number of vertices
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (adjmat[i][j] != 0) {
                    adj.get(i).add(new Edge(j, adjmat[i][j]));
                }
            }
        }
        return adj;
    }
}
