package GraphL3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedKahnBFS {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(2);

        DetectCycleDirectedKahnBFS obj = new DetectCycleDirectedKahnBFS();
        boolean ans = obj.isCyclic(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }

    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        // int topo[] = new int[N];
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            cnt++;
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (cnt == n)
            return false;
        return true;
    }
}
