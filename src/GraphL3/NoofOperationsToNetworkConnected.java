package GraphL3;

import java.util.ArrayList;
import java.util.List;

class NoofOperationsToNetworkConnected {

    private List<Integer> rank;
    private List<Integer> parent;
    private List<Integer> size;
    public NoofOperationsToNetworkConnected(int n) {
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public static void main(String[] args) {

        int V = 9;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // helper to add undirected edge
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 7, 8);

        NoofOperationsToNetworkConnected obj =
                new NoofOperationsToNetworkConnected(V);

        int ans = obj.solve(V, adj);

        System.out.println("The number of operations needed: " + ans);
    }

    static void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v) {
        adj.get(u).add(new Pair(v, 1));
        adj.get(v).add(new Pair(u, 1));
    }

    private int findUPar(int node) {
        if (node == parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    private void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }

    public int solve(int n, ArrayList<ArrayList<Pair>> adj) {

        int extraEdges = 0;

        // Traverse adjacency list
        for (int u = 0; u < n; u++) {
            for (Pair it : adj.get(u)) {
                int v = it.first;

                // To avoid double counting in undirected graph
                if (u < v) {
                    if (findUPar(u) == findUPar(v)) {
                        extraEdges++;
                    } else {
                        unionBySize(u, v);
                    }
                }
            }
        }

        // count components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (parent.get(i) == i) components++;
        }

        int neededEdges = components - 1;

        return (extraEdges >= neededEdges) ? neededEdges : -1;
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;     // node
            this.second = second;   // weight (unused here)
        }
    }
}