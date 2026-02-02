package CodingShuttle.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void main(String[] args) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        int V = 6;
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0, 1, 1);
        addEdge(graph, 0, 4, 1);
        addEdge(graph, 1, 2, 2);
        addEdge(graph, 4, 1, 2);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 3, 1, 3);
        addEdge(graph, 2, 3, 3);
        addEdge(graph, 5, 1, 5);
        addEdge(graph, 3, 5, 6);
        addEdge(graph, 5, 4, 6);
        addEdge(graph, 5, 0, 9);

        int[] ans = minDistanceDijkstras(graph, V, 0);
        for (int i = 0; i < V; i++) {
            System.out.println("0 -> " + i + " = " + ans[i]);
        }
    }

    static int[] minDistanceDijkstras(ArrayList<ArrayList<Pair>> graph, int V, int src) {
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(-1, src, 0));
        boolean[] vis = new boolean[V];

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int cur = edge.dest;
            if (vis[cur]) continue;
            vis[cur] = true;

            ArrayList<Pair> curNeighbors = graph.get(cur);
            for (Pair neighbor : curNeighbors) {
                if (!vis[neighbor.v]) {
                    if (ans[cur] != Integer.MAX_VALUE && ans[neighbor.v] > ans[cur] + neighbor.w) {
                        ans[neighbor.v] = ans[cur] + neighbor.w;
                        pq.add(new Edge(cur, neighbor.v, ans[neighbor.v]));
                    }
                }
            }
        }
        return ans;
    }

    static void addEdge(ArrayList<ArrayList<Pair>> graph, int src, int dest, int wt) {
        graph.get(src).add(new Pair(dest, wt));
        graph.get(dest).add(new Pair(src, wt));
    }

    static class Pair {
        int v, w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static class Edge implements Comparable<Edge> {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge that) {
            return this.wt - that.wt;
        }
    }
}




