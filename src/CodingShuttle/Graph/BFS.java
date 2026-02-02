package CodingShuttle.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 4;
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 2);

        findPath(graph, 3, 1);
    }

    static void findPath(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
        int V = graph.size();
        boolean[] vis = new boolean[V];
        int[] dist = new int[V];
        int[] prec = new int[V];
        bfs(graph, src, vis, dist, prec);

        while (dest != -1) {
            System.out.println(dest);
            dest = prec[dest];
        }
    }

    static void bfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis, int[] dist, int[] prec) {
        Queue<Integer> q = new LinkedList<>();
        vis[src] = true;
        dist[src] = 0;
        prec[src] = -1;
        q.add(src);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int neighbor : graph.get(cur)) {
                if (!vis[neighbor]) {
                    q.add(neighbor);
                    vis[neighbor] = true;
                    dist[neighbor] = dist[cur] + 1;
                    prec[neighbor] = cur;
                }
            }
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
        if (!graph.get(a).contains(b)) {
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }
}
