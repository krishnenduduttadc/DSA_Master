package LeetCodePatterns.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountComponentsUndirected {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };

        CountComponentsUndirected solution = new CountComponentsUndirected();
        int componentCount = solution.countComponents(n, edges);

        System.out.println("Number of connected components: " + componentCount);
    }

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(adjacencyList, visited, i, -1);
            }
        }

        return count;
    }

    private void dfs(List<List<Integer>> adjacencyList, Set<Integer> visited, int node, int parent) {
        visited.add(node);

        for (int neighbor : adjacencyList.get(node)) {
            if (neighbor == parent) continue;

            if (!visited.contains(neighbor)) {
                dfs(adjacencyList, visited, neighbor, node);
            }
        }
    }
}
