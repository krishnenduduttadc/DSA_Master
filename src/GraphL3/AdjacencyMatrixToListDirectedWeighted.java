package GraphL3;

import java.util.ArrayList;

public class AdjacencyMatrixToListDirectedWeighted {
    public static void main(String[] args) {
        int[][] adjmat = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 2, 3, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 0}
        };

        ArrayList<ArrayList<Pair>> weightedAdjacencyList = convertToWeightedAdjacencyList(adjmat);
        for (int i = 1; i < weightedAdjacencyList.size(); i++) {
            System.out.print(i + ": ");
            for (Pair edge : weightedAdjacencyList.get(i)) {
                System.out.print("(" + edge.d + ", " + edge.wt + ") ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Pair>> convertToWeightedAdjacencyList(int[][] adjmat) {
        int v = adjmat.length - 1; // Number of vertices
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (adjmat[i][j] != 0) {
                    adj.get(i).add(new Pair(j, adjmat[i][j]));
                }
            }
        }
        return adj;
    }

    static class Pair {
        int d;
        int wt;

        Pair(int d, int wt) {
            this.d = d;
            this.wt = wt;
        }
    }
}
