package LeetCodePatterns.DP;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    // Main method to test the program
    public static void main(String[] args) {
        Matrix01 solver = new Matrix01();

        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] result = solver.updateMatrix(mat);

        System.out.println("Updated Distance Matrix:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] distance = new int[m][n];
        Queue<String> que = new LinkedList<String>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    distance[i][j] = m * n;
                } else {
                    distance[i][j] = 0;
                    que.add(i + "-" + j);
                }
            }
        }

        while (que.size() > 0) {
            String top = que.poll();
            int row = Integer.parseInt(top.split("-")[0]);
            int col = Integer.parseInt(top.split("-")[1]);
            int newDistance = distance[row][col] + 1;

            if (isValid(row - 1, col, mat) && distance[row - 1][col] > newDistance) {
                distance[row - 1][col] = newDistance;
                que.add((row - 1) + "-" + col);
            }
            if (isValid(row + 1, col, mat) && distance[row + 1][col] > newDistance) {
                distance[row + 1][col] = newDistance;
                que.add((row + 1) + "-" + col);
            }
            if (isValid(row, col - 1, mat) && distance[row][col - 1] > newDistance) {
                distance[row][col - 1] = newDistance;
                que.add(row + "-" + (col - 1));
            }
            if (isValid(row, col + 1, mat) && distance[row][col + 1] > newDistance) {
                distance[row][col + 1] = newDistance;
                que.add(row + "-" + (col + 1));
            }
        }
        return distance;
    }

    boolean isValid(int row, int col, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if (row < 0 || row >= m) return false;
        if (col < 0 || col >= n) return false;
        if (mat[row][col] != 1) return false;
        return true;
    }
}
