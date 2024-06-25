/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPL2;

import java.util.HashMap;

/**
 *
 * @author krish
 */
public class ArithmaticSlice2 {

    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 12, 15, 18, 22, 26, 30, 34, 36, 38, 40, 41};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int ans = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[arr.length];
        for (int i = 0; i < arr.length; i++) {
            maps[i] = new HashMap<>();
        }

        for (int i = 1; i < maps.length; i++) {
            for (int j = 0; j < i; j++) {
                long cd = (long) arr[i] - (long) arr[j];
                if (cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) {
                    continue;
                }
                int apsEndingOnJ = maps[j].getOrDefault((int) cd, 0);
                int apsEndingOnI = maps[i].getOrDefault((int) cd, 0);
                ans += apsEndingOnJ;
                maps[i].put((int) cd, apsEndingOnI + apsEndingOnJ + 1);

            }
        }
        return ans;
    }
}
