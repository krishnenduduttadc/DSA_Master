package CodingShuttle.Graph;

import java.util.ArrayList;

public class Graph {
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

        // Example of graph structure
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Node " + i + " is connected to " + graph.get(i));
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
        if (graph.get(a).contains(b)) return;
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
}
