package Striver_graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoofDistinctIslands {


    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }

    public static void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            int first = q.peek().first;
            int second = q.peek().second;
            q.remove();

            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    int row = r + first;
                    int col = c + second;

                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col] && grid[row][col] == '1') {
                        visited[row][col] = true;
                        q.add(new Pair(row, col));
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        NoofDistinctIslands solution = new NoofDistinctIslands();
        int numberOfIslands = solution.numIslands(grid);

        System.out.println("Number of distinct islands: " + numberOfIslands);
    }


}


