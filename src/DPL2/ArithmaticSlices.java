/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPL2;

/**
 *
 * @author krish
 */
public class ArithmaticSlices {

    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 12, 15, 18, 22, 26, 30, 34, 36, 38, 40, 41};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int[] dp = new int[arr.length];
        int ans = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                ans = ans + dp[i];
            }
        }
        return ans;
    }

}
