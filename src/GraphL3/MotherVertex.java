package GraphL3;


import java.util.ArrayList;
import java.util.Stack;

public class MotherVertex {
    public static void main(String[] args) {
        MotherVertex solution = new MotherVertex();

        // Example graph representation using adjacency list
        int V = 7; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(6).add(4);

        // Finding the mother vertex
        int motherVertex = solution.findMotherVertex(V, adj);

        if (motherVertex != -1) {
            System.out.println("A mother vertex is: " + motherVertex);
        } else {
            System.out.println("No mother vertex found.");
        }
    }

    public int findMotherVertex(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        Stack<Integer> st = new Stack<>();

        // Perform DFS to fill the stack with vertices in finishing order.
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, st);
            }
        }

        // Pop the last vertex from the stack which should be a potential mother vertex.
        int potentialMother = st.pop();

        // Reset visited array for another DFS to check if potentialMother is a mother vertex.
        vis = new boolean[v];
        dfs(adj, potentialMother, vis, st);

        // Check if all vertices are visited in the second DFS starting from potentialMother.
        for (int i = 0; i < v; i++) {
            if (!vis[i]) return -1; // If any vertex is not visited, potentialMother is not a mother vertex.
        }

        return potentialMother;
    }

    // Recursive DFS function to visit all vertices reachable from src.
    public void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis, Stack<Integer> st) {
        vis[src] = true;
        for (int nbr : adj.get(src)) {
            if (!vis[nbr]) {
                dfs(adj, nbr, vis, st);
            }
        }
        st.push(src); // Push vertex to stack after all reachable vertices are visited.
    }
}
