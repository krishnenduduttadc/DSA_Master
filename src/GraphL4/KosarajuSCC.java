package GraphL4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


//Idea (VERY SIMPLE)
//DFS → store nodes by finish time
//Reverse graph
//DFS in reverse order → SCCs

public class KosarajuSCC {

    static List<List<Integer>> graph, reverseGraph;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        int n = 5;

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(1, 3);
        addEdge(3, 4);

        visited = new boolean[n];

        // Step 1: Order by finish time
        for (int i = 0; i < n; i++)
            if (!visited[i])
                dfs1(i);

        Arrays.fill(visited, false);

        // Step 2: Process reversed graph
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                System.out.print("SCC: ");
                dfs2(node);
                System.out.println();
            }
        }
    }

    static void addEdge(int u, int v) {
        graph.get(u).add(v);
        reverseGraph.get(v).add(u);
    }

    static void dfs1(int u) {
        visited[u] = true;
        for (int v : graph.get(u))
            if (!visited[v])
                dfs1(v);
        stack.push(u);
    }

    static void dfs2(int u) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int v : reverseGraph.get(u))
            if (!visited[v])
                dfs2(v);
    }
}

