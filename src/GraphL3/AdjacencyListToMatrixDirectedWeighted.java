package GraphL3;

import java.util.ArrayList;

public class AdjacencyListToMatrixDirectedWeighted {
    static class Edge {
        int d;
        int wt;

        Edge(int d, int wt) {
            this.d = d;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(new Edge(3, 2));
        adj.get(1).add(new Edge(2, 1));
        adj.get(3).add(new Edge(4, 3));
        adj.get(4).add(new Edge(5, 4));

        int[][] adjmat = convertToAdjacencyMatrix(adj, V);

        for (int i = 0; i <= V; i++) {
            for (int j = 0; j <= V; j++) {
                System.out.print(adjmat[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] convertToAdjacencyMatrix(ArrayList<ArrayList<Edge>> adj, int V) {
        int[][] adjmat = new int[V + 1][V + 1];
        for (int i = 0; i <= V; i++) {
            for (Edge e : adj.get(i)) {
                int j = e.d;
                int wt = e.wt;
                adjmat[i][j] = wt;
            }
        }
        return adjmat;
    }
}
