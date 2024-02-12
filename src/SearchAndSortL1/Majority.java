/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchAndSortL1;

/**
 *
 * @author krish
 */
public class Majority {

    public static void main(String[] args) {
        System.out.println(majority(new int[]{6, 8, 4, 8, 8}));
    }

    private static int majority(int[] arr) {
        int res = 0, count = 1;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[res] == arr[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[res] == arr[i]) {
                count++;
            }
        }
        if (count <= n / 2) {
            res = -1;
        }
        return res;

    }
}
