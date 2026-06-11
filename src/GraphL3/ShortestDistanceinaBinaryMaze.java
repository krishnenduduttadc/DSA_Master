package GraphL3;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceinaBinaryMaze {

    static int shortestDistance(int[][] grid, int[] source, int[] destination) {

        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(source[0], source[1], 0));
        visited[source[0]][source[1]] = true;

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            if (current.row == destination[0] &&
                    current.col == destination[1]) {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {

                int newRow = current.row + dr[i];
                int newCol = current.col + dc[i];

                if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < m &&
                        grid[newRow][newCol] == 1 &&
                        !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.offer(new Node(newRow, newCol, current.dist + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}
        };

        int[] source = {0, 0};
        int[] destination = {4, 4};

        System.out.println(shortestDistance(grid, source, destination));
    }

    static class Node {
        int row, col, dist;

        Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}