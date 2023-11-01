package Concepts;

import java.util.LinkedList;
import java.util.Queue;

public class GridTraversalFrom00usingBFS {
    static class Pair {
        int i, j;
        String psf;
        int sum;
        public Pair(int i, int j, String psf,int sum) {
            this.i = i;
            this.j = j;
            this.psf = psf;
            this.sum=sum;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, "",arr[0][0]));
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            if (rem.i==arr.length-1 && rem.j==arr[0].length-1) {
                System.out.println(rem.psf+" "+rem.sum);
            } else if (rem.i==arr.length-1) {
                q.add(new Pair(rem.i,rem.j+1,rem.psf+"H",rem.sum+arr[rem.i][rem.j+1]));
                System.out.println(rem.psf+" "+rem.sum);
            } else if (rem.j==arr[0].length-1) {
                q.add(new Pair(rem.i+1,rem.j,rem.psf+"V",rem.sum+arr[rem.i+1][rem.j]));
                System.out.println(rem.psf+" "+rem.sum);
            } else {
                if(arr[rem.i][rem.j + 1] < arr[rem.i + 1][rem.j]){
                    q.add(new Pair(rem.i,rem.j+1,rem.psf+"H",rem.sum+arr[rem.i][rem.j+1]));
                    System.out.println(rem.psf+" "+rem.sum);

                }else if(arr[rem.i][rem.j + 1] > arr[rem.i + 1][rem.j]){
                    q.add(new Pair(rem.i+1,rem.j,rem.psf+"V",rem.sum+arr[rem.i+1][rem.j]));
                    System.out.println(rem.psf+" "+rem.sum);
                }else{
                    q.add(new Pair(rem.i,rem.j+1,rem.psf+"H",rem.sum+arr[rem.i][rem.j+1]));
                    q.add(new Pair(rem.i+1,rem.j,rem.psf+"V",rem.sum+arr[rem.i+1][rem.j]));
                    System.out.println(rem.psf+" "+rem.sum);
                }
            }
        }

    }
}
