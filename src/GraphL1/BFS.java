package GraphL1;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BFS {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 3, 4);

        System.out.println("Following is Breadth First Traversal: ");
        bfs(adj, V, 0);

    }

    private static void bfs(ArrayList<ArrayList<Integer>> adj, int v, int s) {
        ArrayDeque<Integer> q=new ArrayDeque<>();
        boolean[] visited = new boolean[v];
        q.add(s);

        while(q.size()>0){
            int rem=q.removeFirst();
            if(visited[rem]==true){
                continue;
            }
            visited[rem]=true;
            System.out.print(rem+" ");
            for(int nbr:adj.get(rem)){
                if(visited[nbr]==false){
                    q.add(nbr);
                }
            }
        }

    }
}
