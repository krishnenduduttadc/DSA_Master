package GraphL3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {

    public static void main(String[] args) {

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(4);
        adj.get(4).add(2);
        adj.get(3).add(5);
        adj.get(5).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);

        BipartiteBFS obj = new BipartiteBFS();
        boolean ans = obj.isBipartite(V, adj);

        if (ans) {
            System.out.println("Bipartite");
        } else {
            System.out.println("Non bipartite");
        }
    }

    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {

        boolean[] color = new boolean[v];
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (!check(i, adj, color, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(int s, ArrayList<ArrayList<Integer>> adj,
                          boolean[] color, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visited[s] = true;
        color[s] = false; // first color

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : adj.get(node)) {

                if (!visited[it]) {
                    visited[it] = true;
                    color[it] = !color[node]; // opposite color
                    q.add(it);
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}