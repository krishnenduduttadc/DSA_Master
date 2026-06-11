package GraphL3;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Node> queue = new LinkedList<>();
        int fresh = 0;

        // Put all rotten oranges into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2)
                    queue.offer(new Node(i, j, 0));

                if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int time = 0;

        while (!queue.isEmpty()) {

            Node curr = queue.poll();

            time = curr.time;

            for (int i = 0; i < 4; i++) {

                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];

                if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grid[nr][nc] == 1) {

                    grid[nr][nc] = 2;     // Rot it
                    fresh--;

                    queue.offer(new Node(nr, nc, curr.time + 1));
                }
            }
        }

        return fresh == 0 ? time : -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 2},
                {0, 1, 2},
                {2, 1, 1}
        };

        System.out.println(orangesRotting(grid));
    }

    static class Node {
        int row, col, time;

        Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}