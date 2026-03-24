package GraphL3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleUndirectedBFS {

    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
                                 boolean[] vis) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, -1));
        vis[s] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int node = curr.first;
            int par = curr.second;

            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(new Node(it, node));
                } else if (it != par) {
                    return true; // cycle detected
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= 3; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        CycleUndirectedBFS obj = new CycleUndirectedBFS();
        boolean ans = obj.isCycle(4, adj);

        if (ans) {
            System.out.println("cycle exists");
        } else {
            System.out.println("cycle does not exist");
        }
    }

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (checkForCycle(adj, i, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Node {
        int first;
        int second;

        Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}