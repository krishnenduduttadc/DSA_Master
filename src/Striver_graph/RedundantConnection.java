package Striver_graph;


import java.util.Arrays;

public class RedundantConnection {
    int[] par;
    int[] rank;

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;

        if (rank[px] > rank[py]) {
            par[py] = px;
        } else if (rank[px] < rank[py]) {
            par[px] = py;
        } else {
            par[px] = py;
            rank[py]++;
        }

        return true;
    }

    public int find(int x) {
        if (par[x] == x) return x;

        int t = find(par[x]);
        par[x] = t;
        return t;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int V = edges.length;
        par = new int[V + 1];
        rank = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            boolean flag = union(u, v);
            if (!flag) {
                return edge;
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {
        RedundantConnection solution = new RedundantConnection();

        // Example 1
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[] redundantEdge1 = solution.findRedundantConnection(edges1);
        System.out.println("Redundant edge in Example 1: " + Arrays.toString(redundantEdge1));

        // Example 2
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] redundantEdge2 = solution.findRedundantConnection(edges2);
        System.out.println("Redundant edge in Example 2: " + Arrays.toString(redundantEdge2));

        // Example 3
        int[][] edges3 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        int[] redundantEdge3 = solution.findRedundantConnection(edges3);
        System.out.println("Redundant edge in Example 3: " + Arrays.toString(redundantEdge3));
    }
}
