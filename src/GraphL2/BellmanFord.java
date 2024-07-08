package GraphL2;

import java.io.IOException;
import java.util.Arrays;

public class BellmanFord {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Hardcoded input
        int n = 5; // Number of vertices
        int m = 5; // Number of edges

        int[][] arr = {
                {1, 2, 5},
                {1, 3, 2},
                {3, 4, 1},
                {1, 4, 6},
                {3, 5, 5}
        };

        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0;

        // Performing Bellman-Ford algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int u = arr[j][0] - 1;
                int v = arr[j][1] - 1;
                int wt = arr[j][2];

                if (path[u] == Integer.MAX_VALUE) {
                    continue;
                }

                if (path[u] + wt < path[v]) {
                    path[v] = path[u] + wt;
                }
            }
        }

        // Printing the shortest paths
        for (int i = 1; i < n; i++) {
            if (path[i] != Integer.MAX_VALUE) {
                System.out.print(path[i] + " ");
            } else {
                System.out.print("1000000000 ");
            }
        }
        System.out.println();
    }
}
