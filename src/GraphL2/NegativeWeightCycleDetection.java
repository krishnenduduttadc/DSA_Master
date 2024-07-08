package GraphL2;

import java.util.Arrays;

public class NegativeWeightCycleDetection {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] edges = {
                {0, 1, -1},
                {1, 2, -4},
                {2, 0, 3}
        };

        System.out.println(isNegativeWeightCycle(n, edges));
    }

    public static int isNegativeWeightCycle(int n, int[][] edges) {
        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                if (path[u] == Integer.MAX_VALUE) {
                    continue;
                }
                if (path[u] + wt < path[v]) {
                    path[v] = path[u] + wt;
                }
            }
        }

        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];

            if (path[u] == Integer.MAX_VALUE) {
                continue;
            }
            if (path[u] + wt < path[v]) {
                return 1;
            }
        }
        return 0;
    }
}
