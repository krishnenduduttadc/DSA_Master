package GraphL2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIsland2 {
    public static void main(String[] args) {
        // Hardcoded input
        int m = 3; // Number of rows
        int n = 3; // Number of columns
        int q = 4; // Number of positions

        int[][] positions = {
                {0, 0},
                {0, 1},
                {1, 2},
                {2, 1}
        }; // Array of positions to process

        List<Integer> result = numIslands2(m, n, positions);
        System.out.println(result);
    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int[] par = new int[m * n];
        int[] rank = new int[m * n];
        Arrays.fill(par, -1);
        int count = 0;

        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];

            int cellno = row * n + col;
            if (par[cellno] != -1) {
                ans.add(count);
                continue;
            }

            par[cellno] = cellno;
            rank[cellno] = 1;
            count++;

            for (int[] dir : dirs) {
                int rowdash = row + dir[0];
                int coldash = col + dir[1];
                int celldash = rowdash * n + coldash;

                if (rowdash < 0 || coldash < 0 || rowdash >= m || coldash >= n || par[celldash] == -1) {
                    continue;
                }

                int lx = find(cellno, par);
                int ly = find(celldash, par);

                if (lx != ly) {
                    if (rank[lx] > rank[ly]) {
                        par[ly] = lx;
                    } else if (rank[lx] < rank[ly]) {
                        par[lx] = ly;
                    } else {
                        par[ly] = lx;
                        rank[lx]++;
                    }
                    count--;
                }
            }
            ans.add(count);
        }
        return ans;
    }

    static int find(int x, int[] par) {
        if (par[x] == x) {
            return x;
        }
        int temp = find(par[x], par);
        par[x] = temp;
        return temp;
    }
}
