package CodingShuttle.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {
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

        int mstWeight = mstPrims(graph, V);
        System.out.println("Weight of the Minimum Spanning Tree: " + mstWeight);
    }

    static int mstPrims(ArrayList<ArrayList<Pair>> graph, int V) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(-1, 0, 0));
        boolean[] vis = new boolean[V];
        int ans = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (vis[cur.dest]) continue;
            vis[cur.dest] = true;
            ans += cur.wt;

            ArrayList<Pair> curNeighbors = graph.get(cur.dest);
            for (Pair pair : curNeighbors) {
                if (!vis[pair.v]) {
                    pq.add(new Edge(cur.dest, pair.v, pair.w));
                }
            }
        }
        return ans;
    }

    static void addEdge(ArrayList<ArrayList<Pair>> graph, int src, int dest, int wt) {
        graph.get(src).add(new Pair(dest, wt));
        graph.get(dest).add(new Pair(src, wt));
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

    static class Pair {
        int v, w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
