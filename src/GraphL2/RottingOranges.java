package GraphL2;

import java.util.LinkedList;

public class RottingOranges {
    public static void main(String[] args) {
        // Hardcoded input
        int n = 3; // Number of rows
        int m = 3; // Number of columns
        int[][] arr = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(orangesRotting(arr));
    }

    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int orangesRotting(int[][] arr) {
        LinkedList<Pair> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {
                    q.addLast(new Pair(i, j));
                } else if (arr[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int level = -1;

        while (q.size() > 0) {
            int size = q.size();
            level++;
            while (size-- > 0) {
                Pair rem = q.removeFirst();
                for (int i = 0; i < dirs.length; i++) {
                    int rdash = rem.row + dirs[i][0];
                    int cdash = rem.col + dirs[i][1];

                    if (rdash >= 0 && cdash >= 0 && rdash < arr.length &&
                            cdash < arr[0].length && arr[rdash][cdash] == 1) {
                        q.addLast(new Pair(rdash, cdash));
                        arr[rdash][cdash] = 0;
                        fresh--;
                    }
                }
            }
        }

        if (fresh == 0) {
            return level;
        } else {
            return -1;
        }
    }
}
