package CodingShuttle.Graph;

public class CaptureRegionOnBoard {
    public static void main(String[] args) {
        char[][] a = {
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X'}
        };

        captureBoard(a);

        for (char[] temp : a) {
            for (char c : temp) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    static void captureBoard(char[][] a) {
        int row = a.length;
        int col = a[0].length;
        boolean[][] vis = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            if (a[0][i] == 'O') {
                markAsA(a, 0, i, vis);
            }
            if (a[row - 1][i] == 'O') {
                markAsA(a, row - 1, i, vis);
            }
        }
        for (int i = 0; i < row; i++) {
            if (a[i][0] == 'O') {
                markAsA(a, i, 0, vis);
            }
            if (a[i][col - 1] == 'O') {
                markAsA(a, i, col - 1, vis);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                } else if (a[i][j] == 'A') {
                    a[i][j] = 'O';
                }
            }
        }
    }

    static void markAsA(char[][] a, int i, int j, boolean[][] vis) {
        if (!isSafe(a, i, j)) return;
        if (vis[i][j]) return;

        vis[i][j] = true;
        a[i][j] = 'A';

        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};

        for (int ind = 0; ind < 4; ind++) {
            int nextI = i + x[ind];
            int nextJ = j + y[ind];

            markAsA(a, nextI, nextJ, vis);
        }
    }

    static boolean isSafe(char[][] a, int i, int j) {
        int row = a.length;
        int col = a[0].length;

        return i >= 0 && i < row && j >= 0 && j < col && a[i][j] == 'O';
    }
}
