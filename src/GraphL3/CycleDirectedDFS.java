package GraphL3;

import java.util.ArrayList;

public class CycleDirectedDFS {
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        CycleDirectedDFS obj = new CycleDirectedDFS();
        boolean ans = obj.isCyclic(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");

    }

    private boolean dfsCheck(int s, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[s] = 1;
        pathVis[s] = 1;

        for (int it : adj.get(s)) {
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis))
                    return true;
            } else if (pathVis[it] == 1) {
                return true;
            }
        }
        pathVis[s] = 0;
        return false;
    }

    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[v];
        int pathVis[] = new int[v];
        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }
}


