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
public class TempleOfferings {

    public static void main(String[] args) {
        int[] height = {2, 3, 5, 6, 4, 8, 9};
        System.out.println(totalOfferings(height));
    }

    private static int totalOfferings(int[] height) {
        int[] larr = new int[height.length];
        larr[0] = 1;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[i - 1]) {
                larr[i] = larr[i - 1] + 1;
            } else {
                larr[i] = 1;
            }
        }

        int[] rarr = new int[height.length];
        rarr[rarr.length - 1] = 1;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] > height[i + 1]) {
                rarr[i] = rarr[i + 1] + 1;
            } else {
                rarr[i] = 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.max(larr[i], rarr[i]);
        }
        return ans;
    }
}
