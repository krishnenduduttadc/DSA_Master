package GraphL3;


import java.util.ArrayList;
import java.util.Stack;

public class MotherVertex {
    public static void main(String[] args) {
        MotherVertex solution = new MotherVertex();

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
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, st);
            }
        }
        int potentialMother = st.pop();
        vis = new boolean[v];
        dfs(adj, potentialMother, vis, st);
        for (int i = 0; i < v; i++) {
            if (!vis[i]) return -1; // If any vertex is not visited, potentialMother is not a mother vertex.
        }
        return potentialMother;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] vis, Stack<Integer> st) {
        vis[s] = true;
        for (int it : adj.get(s)) {
            if (!vis[it]) {
                dfs(adj, it, vis, st);
            }
        }
        st.push(s); // Push vertex to stack after all reachable vertices are visited.
    }
}
