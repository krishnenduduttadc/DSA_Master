package Striver_graph;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeState {
    private boolean dfsCheck(int node, List<List<Integer>> adj, int vis[],
                             int pathVis[], int check[]) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        // traverse for adjacent nodes
        for (int it : adj.get(node)) {
            // when the node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis, check) == true)
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if (pathVis[it] == 1) {
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1)
                safeNodes.add(i);
        }
        return safeNodes;
        // Your code here
    }

    public static void main(String[] args) {
        int V = 12;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);

        EventualSafeState obj = new EventualSafeState();
        List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
        for (int node : safeNodes) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
