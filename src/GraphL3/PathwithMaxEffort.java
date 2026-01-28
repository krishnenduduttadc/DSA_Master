package GraphL3;

import java.util.PriorityQueue;

class PathwithMaxEffort {

    public static void main(String[] args) {

        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        PathwithMaxEffort obj = new PathwithMaxEffort();
        int ans = obj.MinimumEffort(heights);
        System.out.print(ans);
        System.out.println();
    }

    int MinimumEffort(int heights[][]) {

        PriorityQueue<Tuple> pq =
                new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) (1e9);
            }
        }
        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Tuple it = pq.peek();
            pq.remove();
            int diff = it.distance;
            int row = it.row;
            int col = it.col;

            if (row == n - 1 && col == m - 1) return diff;

            for (int i = 0; i < 4; i++) {
                int newr = row + dr[i];
                int newc = col + dc[i];
                if (newr >= 0 && newc >= 0 && newr < n && newc < m) {
                    int newEffort =
                            Math.max(
                                    Math.abs(heights[row][col] - heights[newr][newc]), diff);
                    if (newEffort < dist[newr][newc]) {
                        dist[newr][newc] = newEffort;
                        pq.add(new Tuple(newEffort, newr, newc));
                    }
                }
            }
        }
        return 0;
    }

    static class Tuple {
        int distance;
        int row;
        int col;

        public Tuple(int distance, int row, int col) {
            this.row = row;
            this.distance = distance;
            this.col = col;
        }
    }
}