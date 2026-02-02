package CodingShuttle.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Kahn {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 6;
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 2, 3);
        addEdge(graph, 2, 1);
        addEdge(graph, 3, 1);
        addEdge(graph, 5, 1);
        addEdge(graph, 4, 1);
        addEdge(graph, 4, 5);

        topologicalOrderingKahnAlgo(graph, V);
    }

    static void topologicalOrderingKahnAlgo(ArrayList<ArrayList<Integer>> graph, int V) {
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int e : graph.get(i)) {
                inDegree[e]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.println(cur);

            for (int neighbor : graph.get(cur)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
        if (graph.get(a).contains(b)) return;
        graph.get(a).add(b);
    }
}
