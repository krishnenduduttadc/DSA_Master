package RecursionAndBacktrackingL3;

public class RatInMaze {


    static int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
    };

    static int n = 4;

    public static void main(String[] args) {

        boolean[][] visited = new boolean[n][n];

        backtrack(0, 0, visited, "");
    }

    public static void backtrack(int i, int j, boolean[][] visited, String path) {

        if (i == n - 1 && j == n - 1) {
            System.out.println(path);
            return;
        }

        if (i < 0 || j < 0 || i >= n || j >= n
                || maze[i][j] == 0 || visited[i][j])
            return;

        visited[i][j] = true;

        backtrack(i + 1, j, visited, path + "D");
        backtrack(i, j + 1, visited, path + "R");
        backtrack(i - 1, j, visited, path + "U");
        backtrack(i, j - 1, visited, path + "L");

        visited[i][j] = false;
    }

}
