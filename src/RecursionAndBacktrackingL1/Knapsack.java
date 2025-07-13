/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

/**
 * @author krish
 */
public class Knapsack {

    static int knapsack(int value[], int wt[], int n, int W) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] > W) {
            return knapsack(value, wt, n - 1, W);
        }
        return Math.max(knapsack(value, wt, n - 1, W - wt[n - 1]) + value[n - 1], knapsack(value, wt, n - 1, W));
    }

    public static void main(String[] args) {
        int wt[] = {10, 20, 30};
        int value[] = {100, 50, 150};
        int W = 50;
        System.out.println(knapsack(value, wt, 3, W));

    }
}
