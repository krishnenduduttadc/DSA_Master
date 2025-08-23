package GreedyL2;

//Given an amount, minimize the number of coins required.

import java.util.ArrayList;
import java.util.List;

public class MinCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int amount = 2753;

        List<Integer> result = new ArrayList<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                result.add(coins[i]);
            }
        }

        System.out.println("Coins used: " + result);
        System.out.println("Min number of coins = " + result.size());
    }
}

