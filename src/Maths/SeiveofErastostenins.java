/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maths;

import java.util.Arrays;

/**
 *
 * @author krish
 */
public class SeiveofErastostenins {

    public static void main(String[] args) {
        boolean myseive[] = seive(20);
        for (int i = 0; i < myseive.length; i++) {
            System.out.println(i + " " + myseive[i]);
        }
    }

    static boolean[] seive(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = 2 * i; j <= n; j = j + i) {
                arr[j] = false;
            }
        }
        return arr;
    }
}
