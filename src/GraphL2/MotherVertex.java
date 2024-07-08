package GraphL2;

import java.util.ArrayList;
import java.util.Stack;

public class MotherVertex {
    public static void main(String args[]) {
        int n = 4;
        int m = 3;
        int[][] edges = {
                {1, 2},
                {2, 3},
                {3, 4}
        };

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            graph.get(u).add(v);
        }

        System.out.println(findMotherVertex(n, graph));
    }

    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Perform DFS and fill the stack
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i, stack);
            }
        }

        // Step 2: Find the last finished vertex in DFS (top of the stack)
        int potentialMother = stack.pop();

        // Step 3: Reset visited array and perform DFS from the potential mother vertex
        visited = new boolean[N];
        int count = 0; // Local count to check if all vertices are reachable

        dfs(adj, visited, potentialMother, count); // Pass count to DFS

        // Step 4: Check if all vertices are reachable from the potential mother vertex
        if (count == N) {
            return potentialMother + 1; // Convert zero-based index to one-based index
        } else {
            return -1;
        }
    }

    // DFS to fill the stack
    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int cur, Stack<Integer> stack) {
        visited[cur] = true;

        for (int nbrs : graph.get(cur)) {
            if (!visited[nbrs]) {
                dfs(graph, visited, nbrs, stack);
            }
        }
        stack.push(cur);
    }

    // DFS to count reachable vertices
    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int cur, int count) {
        visited[cur] = true;
        count++; // Increment count for each reachable vertex

        for (int nbrs : graph.get(cur)) {
            if (!visited[nbrs]) {
                dfs(graph, visited, nbrs, count);
            }
        }
    }
}
