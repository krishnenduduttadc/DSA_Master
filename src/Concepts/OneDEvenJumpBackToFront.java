package Concepts;

import java.util.LinkedList;
import java.util.Queue;

public class OneDEvenJumpBackToFront {
    static class Pair {
        int i;
        int v;
        String psf;

        Pair(int i, int v, String psf) {
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 18, 19, 21, 22, 23, 24, 27, 56};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(arr.length - 1, arr[arr.length - 1], arr[arr.length - 1] + ""));

        while (!q.isEmpty()) {
            Pair rem = q.poll();
            int i = rem.i;
            String psf = rem.psf;
            i--;
            if (i >= 0) {
                if (arr[i] % 2 == 0) {
                    q.add(new Pair(i, arr[i], psf + "->" + arr[i]));
                } else {
                    q.add(new Pair(i, arr[i], psf));
                }
            } else {
                System.out.println(psf);
                break;
            }
        }
    }
}

