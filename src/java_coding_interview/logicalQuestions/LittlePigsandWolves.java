package java_coding_interview.logicalQuestions;

public class LittlePigsandWolves {
    public static void main(String[] args) {
        solve();

    }

    static int count = Integer.MAX_VALUE;
    int n;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void solve() {
        int n = 4, m = 4;
        String[] grid = {
                "PPWW",
                "W..W",
                ".P.P",
                "WW.."
        };
        char[][] a = new char[n][m];
        for (int i = 0; i < a.length; i++) {
            String s = grid[i];
            for (int j = 0; j < s.length(); j++) {
                a[i][j] = s.charAt(j);
            }
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'W') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (0 <= x && x < n && 0 <= y && y < m) {
                            if (a[x][y] == 'P') {
                                count++;
                                a[x][y] = '.';
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
