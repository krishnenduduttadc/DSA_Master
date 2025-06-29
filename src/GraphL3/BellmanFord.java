package GraphL3;

import java.util.*;
import java.util.Arrays;

public class BellmanFord {

    public static void main(String[] args) {
        int V = 6;
        int s = 0;


        List<List<Integer>> edges = new ArrayList<>();

        edges.add(Arrays.asList(3, 2, 6));
        edges.add(Arrays.asList(5, 3, 1));
        edges.add(Arrays.asList(0, 1, 5));
        edges.add(Arrays.asList(1, 5, -3));
        edges.add(Arrays.asList(1, 2, -2));
        edges.add(Arrays.asList(3, 4, -2));
        edges.add(Arrays.asList(2, 4, 3));




        int[] dist = BellmanFord.bellman_ford(V, edges, s);
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println("");
    }

    static int[] bellman_ford(int V,
                              List<List<Integer>> edges, int s) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = (int)(1e8);
        dist[s]=0;
        for (int i = 0; i < V - 1; i++) {
            for (List<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check negative cycle
        for (List<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}