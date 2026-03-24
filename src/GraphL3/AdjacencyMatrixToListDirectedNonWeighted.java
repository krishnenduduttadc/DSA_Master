package GraphL3;

import java.util.ArrayList;

public class AdjacencyMatrixToListDirectedNonWeighted {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };

        ArrayList<ArrayList<Integer>> adj = convertToAdjacencyList(adjacencyMatrix);
        for (int i = 1; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> convertToAdjacencyList(int[][] adjacencyMatrix) {
        int v = adjacencyMatrix.length - 1; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i <= v; i++) {
            for (int j = 0; j <= v; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }
}
