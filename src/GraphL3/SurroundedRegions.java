package GraphL3;

public class SurroundedRegions {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static void dfs(int row, int col, char[][] board, boolean[][] visited) {

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {

            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < board.length &&
                    newCol >= 0 && newCol < board[0].length &&
                    !visited[newRow][newCol] &&
                    board[newRow][newCol] == 'O') {

                dfs(newRow, newCol, board, visited);
            }
        }
    }

    static char[][] fill(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        // First and last rows
        for (int col = 0; col < m; col++) {

            if (board[0][col] == 'O' && !visited[0][col])
                dfs(0, col, board, visited);

            if (board[n - 1][col] == 'O' && !visited[n - 1][col])
                dfs(n - 1, col, board, visited);
        }

        // First and last columns
        for (int row = 0; row < n; row++) {

            if (board[row][0] == 'O' && !visited[row][0])
                dfs(row, 0, board, visited);

            if (board[row][m - 1] == 'O' && !visited[row][m - 1])
                dfs(row, m - 1, board, visited);
        }

        // Flip all unvisited O's
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {

                if (board[row][col] == 'O' && !visited[row][col]) {
                    board[row][col] = 'X';
                }
            }
        }

        return board;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}
        };

        fill(board);

        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}