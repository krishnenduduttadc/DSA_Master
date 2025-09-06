package LeetCodePatterns.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidTree {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};

        ValidTree solution = new ValidTree();

        System.out.println("Graph 1 is a valid tree? " + solution.validTree(n, edges1));
        System.out.println("Graph 2 is a valid tree? " + solution.validTree(n, edges2));
    }

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        // Check for cycles
        if (!dfs(adjacencyList, visited, 0, -1)) {
            return false;
        }

        // Check if graph is connected
        return visited.size() == n;
    }

    private boolean dfs(List<List<Integer>> adjacencyList, Set<Integer> visited, int node, int parent) {
        visited.add(node);
        for (int neighbor : adjacencyList.get(node)) {
            if (neighbor == parent) continue;

            if (visited.contains(neighbor)) {
                return false; // cycle detected
            }

            if (!dfs(adjacencyList, visited, neighbor, node)) {
                return false;
            }
        }
        return true;
    }
}
