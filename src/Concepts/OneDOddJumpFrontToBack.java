package Concepts;

import java.util.LinkedList;
import java.util.Queue;

public class OneDOddJumpFrontToBack {
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
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 18, 19, 21, 22, 23, 24, 27, 56};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, arr[0], arr[0] + ""));

        while (!q.isEmpty()) {
            Pair rem=q.poll();
            int i=rem.i;
            int v=rem.v;
            String psf=rem.psf;
            i++;
            if(i<=arr.length-1){
                if(arr[i]%2!=0){
                    q.add(new Pair(i,arr[i],psf+"->"+arr[i]));
                }else{
                    q.add(new Pair(i,arr[i],psf));
                }
            }else{
                System.out.println(psf);
                return;
            }
        }
    }
}
