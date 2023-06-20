package DP;

import java.util.ArrayDeque;

public class PrintAllLIS {
    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80, 3};
        int n = arr.length;
        int[] dp = new int[n];
        int omax = 0;
        int omi=0;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];
                omi=i;
            }
        }

        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.add(new Pair(omax,omi,arr[omi],arr[omi]+""));
        while(!q.isEmpty()){
            Pair rem=q.removeFirst();
            if(rem.l==1){
                System.out.println(rem.psf);
            }

            for(int j=rem.i-1;j>=0;j--){
                if(dp[j]==rem.l-1 && arr[j]<=rem.v){
                    q.add(new Pair(dp[j],j,arr[j],arr[j]+" -> "+rem.psf));
                }
            }

        }


    }




    static class Pair {
        int l, i, v;
        String psf;

        Pair(int l, int i, int v, String psf) {
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
}
