package GraphL1;

import java.util.ArrayList;

public class DFS {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 3, 4);

        System.out.println("Following is Depth First Traversal: ");
        DFS(adj, V, 0);
    }
    static void DFS(ArrayList<ArrayList<Integer>> adj, int V, int s) {
        boolean[] visited = new boolean[V];
        DFSR(adj,s,visited);
    }

    private static void DFSR(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s]=true;
        System.out.print(s+" ");
        for(int nbr:adj.get(s)){
            if(visited[nbr]==false){
                visited[nbr]=true;
                DFSR(adj,nbr,visited);
            }
        }
    }
}
