package CodeChef_java_coding_interview.logicalQuestions;

import java.util.HashSet;
import java.util.Set;

public class FaceDetection {
    public static void main(String[] args) {

        solve();
    }

    static void solve() {
        int n = 4;
        int m = 4;
        char[][] input = {
                {'x', 'x', 'x', 'x'},
                {'x', 'f', 'a', 'x'},
                {'x', 'c', 'e', 'x'},
                {'x', 'f', 'a', 'x'}
        };
        char[][] grid = new char[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i + 1][j + 1] = input[i][j];
            }
        }

        int total = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (valid(input, i, j)) {
                    total++;
                }
            }
        }
        System.out.println(total);
    }

    private static boolean valid(char[][] grid, int i, int j) {
        Set<Character> set = new HashSet<Character>();

        set.add(grid[i][j]);
        set.add(grid[i][j + 1]);
        set.add(grid[i + 1][j]);
        set.add(grid[i + 1][j + 1]);

        if (set.contains('f') && set.contains('a') && set.contains('c') && set.contains('e')) {
            return true;
        }

        return false;

    }
}
