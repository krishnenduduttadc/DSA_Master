/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPL2;


public class CountValleysandMountains {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int inside = i - 1;
            int outside = i - inside;
            while (inside >= 0) {
                dp[i] = dp[i] + dp[outside] * dp[inside];
                inside--;
                outside++;
            }
        }
        System.out.println(dp[n]);

    }
}
