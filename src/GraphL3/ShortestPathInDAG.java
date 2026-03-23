package GraphL3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathInDAG {

    public static void main(String[] args) {

        int N = 6;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // u → v (weight)
        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(4).add(new Pair(5, 4));
        adj.get(4).add(new Pair(2, 2));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(3, 6));
        adj.get(5).add(new Pair(3, 1));

        ShortestPathInDAG obj = new ShortestPathInDAG();
        int[] res = obj.shortestPath(N, adj);

        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj,
                          int[] visited, Stack<Integer> stack) {

        visited[node] = 1;

        for (Pair it : adj.get(node)) {
            int v = it.first;

            if (visited[v] == 0) {
                topoSort(v, adj, visited, stack);
            }
        }

        stack.push(node);
    }

    public int[] shortestPath(int N, ArrayList<ArrayList<Pair>> adj) {

        int[] visited = new int[N];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Topological Sort
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                topoSort(i, adj, visited, stack);
            }
        }

        // Step 2: Distance array
        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);

        dist[0] = 0; // source = 0

        // Step 3: Relax edges in topo order
        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (dist[node] != (int) 1e9) { // important check

                for (Pair it : adj.get(node)) {
                    int v = it.first;
                    int wt = it.second;

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        // Step 4: Replace unreachable with -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;     // node
            this.second = second;   // weight
        }
    }
}
