package DPL2;

import java.util.Arrays;

public class MaximumNonOverlappingBrdige {
    public static class Bridge implements Comparable<Bridge> {
        int n;
        int s;

        Bridge(int n, int s){
            this.n = n;
            this.s = s;
        }

        public int compareTo(Bridge o){
            if(this.n != o.n){
                return this.n - o.n;
            } else {
                return this.s - o.s;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 10;
        Bridge[] bdgs = new Bridge[n];
        int[] nr={10,2,8,17,21,50,41,60,80,1};
        int[] s={20,7,15,3,40,4,57,80,90,30};
        for(int i = 0; i < n; i++){
            bdgs[i] = new Bridge(nr[i], s[i]);
        }
        Arrays.sort(bdgs);
        int[] dp = new int[n];
        int omax = 0;
        for(int i = 0; i < dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(bdgs[j].s <= bdgs[i].s){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if(dp[i] > omax){
                omax = dp[i];
            }
        }

        System.out.println(omax);
    }
}
