package RecursionL2;

public class WordSearch {
    static boolean f(char[][] b, int i, int j, String w, int k) {

        if (k == w.length()) return true;

        if (i < 0 || j < 0 || i == b.length || j == b[0].length || b[i][j] != w.charAt(k))
            return false;

        char t = b[i][j];
        b[i][j] = '#';

        boolean r =
                f(b, i + 1, j, w, k + 1) ||
                        f(b, i - 1, j, w, k + 1) ||
                        f(b, i, j + 1, w, k + 1) ||
                        f(b, i, j - 1, w, k + 1);

        b[i][j] = t;
        return r;
    }

    public static void main(String[] args) {

        char[][] b = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(f(b, 0, 0, "ABCCED", 0));
    }
}
