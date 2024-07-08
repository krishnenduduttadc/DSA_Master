package GraphL2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class OptimizeWaterDistribution {
    public static void main(String[] args) {
        // Hardcoded input
        int v = 3; // Number of vertices (nodes)
        int e = 2; // Number of edges (pipes)

        int[] wells = {1, 2, 2}; // Costs of wells at each node

        int[][] pipes = {
                {1, 2, 1},
                {2, 3, 1}
        }; // Each row represents an edge: [start node, end node, cost]

        System.out.println(minCostToSupplyWater(v, wells, pipes));
    }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Constructing the graph with wells and pipes
        for (int i = 0; i < pipes.length; i++) {
            int u = pipes[i][0];
            int v = pipes[i][1];
            int wt = pipes[i][2];

            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }

        // Adding wells as edges from node 0 to each node i
        for (int i = 1; i <= n; i++) {
            graph.get(i).add(new Pair(0, wells[i - 1]));
            graph.get(0).add(new Pair(i, wells[i - 1]));
        }

        int ans = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        boolean[] vis = new boolean[n + 1];

        // Applying Prim's algorithm to find minimum cost
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            if (vis[rem.vtx]) {
                continue;
            }
            ans += rem.wt;
            vis[rem.vtx] = true;

            ArrayList<Pair> nbrs = graph.get(rem.vtx);
            for (Pair nbr : nbrs) {
                if (!vis[nbr.vtx]) {
                    pq.add(nbr);
                }
            }
        }
        return ans;
    }

    static class Pair implements Comparable<Pair> {
        int vtx;
        int wt;

        Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }
}
