package Striver_graph;

import java.util.ArrayList;

public class ArticulationPoint {
    private int timer = 1;

    private void dfs(int node, int parent, int[] vis,
                     int tin[], int low[], int[] mark,
                     ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for (Integer it : adj.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        if (child > 1 && parent == -1) {
            mark[node] = 1;
        }
    }

    public ArrayList<Integer> articulationPoints(int n,
                                                 ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }
        if (ans.size() == 0) {
            ans.add(-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1}, {1, 4},
                {2, 4}, {2, 3}, {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ArticulationPoint obj = new ArticulationPoint();
        ArrayList<Integer> nodes = obj.articulationPoints(n, adj);

        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            int node = nodes.get(i);
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}