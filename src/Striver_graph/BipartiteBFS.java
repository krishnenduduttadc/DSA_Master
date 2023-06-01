package Striver_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {
    private boolean check(int start, int V,
                          ArrayList<ArrayList<Integer>>adj, int color[]) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for(int it : adj.get(node)) {
                // if the adjacent node is yet not colored
                // you will give the opposite color of the node
                if(color[it] == -1) {

                    color[it] = 1 - color[node];
                    q.add(it);
                }
                // is the adjacent guy having the same color
                // someone did color it on some other path
                else if(color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V];
        for(int i = 0;i<V;i++) color[i] = -1;

        for(int i = 0;i<V;i++) {
            if(color[i] == -1) {
                if(check(i, V, adj, color) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        // V = 4, E = 4
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList< >());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        BipartiteBFS obj = new BipartiteBFS();
        boolean ans = obj.isBipartite(4, adj);
        if(ans)
            System.out.println("1");
        else System.out.println("0");
    }

}
