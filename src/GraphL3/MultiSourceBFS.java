package GraphL3;

import java.util.*;

public class MultiSourceBFS {
    public static void main(String[] args) {
        int n = 6; // number of nodes
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Example edges
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);
        List<Integer> sources = new ArrayList<>();
        sources.add(0);
        sources.add(5);
        int[] dist = multisourceBFS(n, adj, sources);
        System.out.println("Distances from nearest source:");
        System.out.println(Arrays.toString(dist));


    }

    public static int[] multisourceBFS(int n, List<List<Integer>> adj, List<Integer> sources) {
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int s : sources) {
            q.add(s);
            distance[s] = 0;
        }
        while (!q.isEmpty()) {
            int u = q.peek();
            q.poll();
            for (int v : adj.get(u)) {
                if (distance[v] == -1) {
                    distance[v] = distance[u] + 1;
                    q.add(v);
                }
            }
        }
        return distance;
    }
}
