package GraphL3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BidirectionalBFS {

    static int bidirectionalBFS(int n, List<List<Integer>> adj, int src, int dest) {
        if (src == dest) return 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        boolean[] vis1 = new boolean[n];
        boolean[] vis2 = new boolean[n];

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        q1.add(src);
        q2.add(dest);
        vis1[src] = true;
        vis2[dest] = true;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int ans = expand(adj, q1, vis1, vis2, dist1, dist2);
            if (ans != -1) return ans;

            ans = expand(adj, q2, vis2, vis1, dist2, dist1);
            if (ans != -1) return ans;
        }

        return -1; // no path
    }

    static int expand(List<List<Integer>> adj,
                      Queue<Integer> queue,
                      boolean[] visCurr,
                      boolean[] visOther,
                      int[] distCurr,
                      int[] distOther) {

        int size = queue.size();
        while (size-- > 0) {
            int u = queue.poll();

            for (int v : adj.get(u)) {
                if (!visCurr[v]) {
                    visCurr[v] = true;
                    distCurr[v] = distCurr[u] + 1;
                    queue.add(v);

                    // Meet point
                    if (visOther[v]) {
                        return distCurr[v] + distOther[v];
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        // Undirected graph
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(5);
        adj.get(5).add(4);

        int src = 0;
        int dest = 5;

        int result = bidirectionalBFS(n, adj, src, dest);
        System.out.println("Shortest distance: " + result);
    }
}
