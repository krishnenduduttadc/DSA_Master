package Striver_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V];
        for (int i = 0; i < V; i++) color[i] = -1;

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (check(i, V, adj, color) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // V = 4, E = 4
        int V=6;
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
        //System.out.println(ans);
        if (ans==true){
            System.out.println("Bipartite");
        }

        else {
            System.out.println("Non bipartite");
        }

    }

    private boolean check(int s, int v,
                          ArrayList<ArrayList<Integer>> adj, int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        color[s] = 0;
        System.out.println(s+" "+color[s]);
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int it : adj.get(node)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    System.out.println(it+" "+color[it]);
                    q.add(it);
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}