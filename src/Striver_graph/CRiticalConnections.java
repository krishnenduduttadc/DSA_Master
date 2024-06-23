package Striver_graph;

import RecursionAndBacktrackingL1.Solution;

import java.util.ArrayList;
import java.util.List;

public class CRiticalConnections {
    boolean[] vis;
    int[] disc;
    int[] low;
    int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        vis = new boolean[n];
        disc = new int[n];
        low = new int[n];
        bridges(graph, n, 0, -1, ans);
        return ans;
    }

    public void bridges(List<List<Integer>> graph, int n, int src, int par, List<List<Integer>> ans) {
        disc[src] = time;
        low[src] = time;
        time++;

        List<Integer> nbrs = graph.get(src);
        for (int nbr : nbrs) {
            if (nbr == par) continue;
            else if (vis[nbr] == false) {
                vis[nbr] = true;
                bridges(graph, n, nbr, src, ans);
                low[src] = Math.min(low[src], low[nbr]);
                if (low[nbr] > disc[src]) {
                    List<Integer> aa = new ArrayList<>();
                    aa.add(src);
                    aa.add(nbr);
                    ans.add(aa);
                }
            } else {
                low[src] = Math.min(low[src], disc[nbr]);
            }
        }
    }

    public static void main(String[] args) {
        CRiticalConnections solution = new CRiticalConnections();

        // Example graph representation
        int n = 5;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(List.of(0, 1));
        connections.add(List.of(0, 2));
        connections.add(List.of(1, 2));
        connections.add(List.of(2, 3));
        connections.add(List.of(3, 4));

        // Finding critical connections (bridges)
        List<List<Integer>> criticalConnections = solution.criticalConnections(n, connections);

        // Printing out the critical connections
        System.out.println("Critical Connections (Bridges):");
        for (List<Integer> connection : criticalConnections) {
            System.out.println(connection.get(0) + " - " + connection.get(1));
        }
    }
}
