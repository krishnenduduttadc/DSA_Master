package GraphL2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumCostToConnectAllCities {
    static class Edge implements Comparable<Edge> {
        int v;
        int wt;

        Edge(int nbr, int wt) {
            this.v = nbr;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {
        int vtces = 7; // Number of vertices
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vtces; i++) {
            graph.add(new ArrayList<>());
        }

        // Hardcoded edges
        int edges = 8; // Number of edges
        int[][] inputEdges = {
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {0, 3, 40},
                {3, 4, 2},
                {4, 5, 3},
                {5, 6, 3},
                {4, 6, 8}
        };

        for (int i = 0; i < edges; i++) {
            int v1 = inputEdges[i][0];
            int v2 = inputEdges[i][1];
            int wt = inputEdges[i][2];
            graph.get(v1).add(new Edge(v2, wt));
            graph.get(v2).add(new Edge(v1, wt));
        }

        int ans = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[vtces];
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge rem = pq.remove();
            if (vis[rem.v]) {
                continue;
            }
            vis[rem.v] = true;
            ans += rem.wt;
            ArrayList<Edge> nbrs = graph.get(rem.v);
            for (Edge nbr : nbrs) {
                if (!vis[nbr.v]) {
                    pq.add(nbr);
                }
            }
        }

        System.out.println(ans);
    }
}
