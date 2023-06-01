package GraphL1;

import java.util.ArrayList;

public class IsConnected {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void drawTree(ArrayList<ArrayList<Integer>> adj, int src, ArrayList<Integer> comp, boolean[] visited) {
        visited[src] = true;
        comp.add(src);

        for (int nbr : adj.get(src)) {
            if (visited[nbr] == false) {
                drawTree(adj, nbr, comp, visited);
            }

        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 3, 4);

        ArrayList<ArrayList<Integer>> comps=new ArrayList<ArrayList<Integer>>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(visited[i]==false){
                ArrayList<Integer> comp=new ArrayList<>();
                drawTree(adj,i,comp,visited);
                comps.add(comp);
            }
        }

        System.out.println(comps.size()>1?false:true);
    }
}
