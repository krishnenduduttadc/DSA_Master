package Striver_graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathInDAG {

    static class Pair {
        int first, second;

        Pair(int _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }

    private void topologicalSort(int node, ArrayList<ArrayList<Pair>> adj, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;
        for (Pair neighbor : adj.get(node)) {
            int v = neighbor.first;
            if (visited[v] == 0) {
                topologicalSort(v, adj, visited, stack);
            }
        }
        stack.push(node);
    }

    public int[] findShortestPaths(int numNodes, int numEdges, int[][] edges) {
        ArrayList<ArrayList<Pair>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < numEdges; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            adjacencyList.get(u).add(new Pair(v, weight));
        }

        int[] visited = new int[numNodes];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numNodes; i++) {
            if (visited[i] == 0) {
                topologicalSort(i, adjacencyList, visited, stack);
            }
        }

        int[] distances = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            distances[i] = (int) 1e9;
        }

        distances[0] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (Pair neighbor : adjacencyList.get(node)) {
                int v = neighbor.first;
                int weight = neighbor.second;

                if (distances[node] + weight < distances[v]) {
                    distances[v] = distances[node] + weight;
                }
            }
        }

        for (int i = 0; i < numNodes; i++) {
            if (distances[i] == 1e9) {
                distances[i] = -1;
            }
        }

        return distances;
    }

    public static void main(String[] args) throws IOException {
        int numNodes = 6, numEdges = 7;
        int[][] edges = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        ShortestPathInDAG shortestPathFinder = new ShortestPathInDAG();
        int[] result = shortestPathFinder.findShortestPaths(numNodes, numEdges, edges);

        for (int distance : result) {
            System.out.print(distance + " ");
        }
        System.out.println();
    }
}
