package GraphL3;

import java.util.ArrayList;

public class CycleUndirectedDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        CycleUndirectedDFS obj = new CycleUndirectedDFS();
        boolean ans = obj.isCycle(4, adj);
        if (ans)
            System.out.println("cycle exists");
        else
            System.out.println("cycle does not exist");
    }

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (vis[i] == false) {
                if (dfs(i, -1, vis, adj) == true) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>>
            adj) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                if (dfs(it, node, vis, adj) == true) {
                    return true;
                }
            } else if (it != parent) {
                return true;
            }
        }
        return false;
    }
}
