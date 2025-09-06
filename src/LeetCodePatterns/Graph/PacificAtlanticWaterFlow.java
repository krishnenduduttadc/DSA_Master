package LeetCodePatterns.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        Solution solution = new Solution();
        List<List<Integer>> result = solution.pacificAtlantic(heights);

        System.out.println("Cells that can reach both Pacific and Atlantic oceans:");
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }
    }

    static class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> result = new ArrayList<>();

            if (heights == null || heights.length == 0 || heights[0].length == 0) {
                return result;
            }

            int m = heights.length;
            int n = heights[0].length;

            boolean[][] canReachPacific = new boolean[m][n];
            boolean[][] canReachAtlantic = new boolean[m][n];

            // Perform DFS from borders
            for (int j = 0; j < n; j++) {
                dfs(heights, canReachPacific, 0, j);
                dfs(heights, canReachAtlantic, m - 1, j);
            }

            for (int i = 0; i < m; i++) {
                dfs(heights, canReachPacific, i, 0);
                dfs(heights, canReachAtlantic, i, n - 1);
            }

            // Collect cells reachable by both oceans
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                        result.add(Arrays.asList(i, j));
                    }
                }
            }

            return result;
        }

        private void dfs(int[][] heights, boolean[][] canReach, int i, int j) {
            int m = heights.length;
            int n = heights[0].length;

            canReach[i][j] = true;

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newRow = i + dir[0];
                int newCol = j + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                        !canReach[newRow][newCol] &&
                        heights[newRow][newCol] >= heights[i][j]) {
                    dfs(heights, canReach, newRow, newCol);
                }
            }
        }
    }
}

