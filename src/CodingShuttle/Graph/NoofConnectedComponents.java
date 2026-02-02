package CodingShuttle.Graph;

import java.util.ArrayList;

public class NoofConnectedComponents {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 8;
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 5, 2);
        addEdge(graph, 1, 5);
        addEdge(graph, 3, 6);

        System.out.println(numberOfConnectedComponents(graph, V));
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int cur) {
        vis[cur] = true;
        for (int neighbor : graph.get(cur)) {
            if (!vis[neighbor]) {
                dfs(graph, vis, neighbor);
            }
        }
    }

    static int numberOfConnectedComponents(ArrayList<ArrayList<Integer>> graph, int V) {
        boolean[] vis = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                count++;
                dfs(graph, vis, i);
            }
        }
        return count;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
        if (graph.get(a).contains(b)) return;
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
}
