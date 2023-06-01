package GraphL1;

import java.util.ArrayList;

public class BackEdge {
    static int V = 7;
    static int[] visited = new int[V+1];
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 1, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        addEdge(adj, 7, 4);

        System.out.println("Following is Depth First Traversal: ");
        DFS(adj, V, 1);
    }

    static void DFS(ArrayList<ArrayList<Integer>> adj, int V, int s) {

        for (int i = 1; i <= V ; i++) {
            if(visited[i]==0){
                DFSR(adj, i, 0);
            }

        }

    }

    private static void DFSR(ArrayList<ArrayList<Integer>> adj, int s, int par) {
        System.out.println(s + " ");
        visited[s] = 1;
        for (int nbr : adj.get(s)) {
            if (visited[nbr] == 0) {
                DFSR(adj, nbr, s);
            } else if (nbr != par) {
                System.out.println(s + "  " + nbr);
            }
        }
    }
}
