package LeetCodePatterns.Graph;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;

        FloodFill solution = new FloodFill();
        int[][] result = solution.floodFill(image, sr, sc, newColor);

        System.out.println("Flood-filled image:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;

        dfs(image, sr, sc, oldColor, color);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image, row - 1, col, oldColor, newColor); // Up
        dfs(image, row + 1, col, oldColor, newColor); // Down
        dfs(image, row, col - 1, oldColor, newColor); // Left
        dfs(image, row, col + 1, oldColor, newColor); // Right
    }
}
