/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreedyL1;

import java.util.Arrays;

/**
 * @author krish
 */
class Item implements Comparable<Item> {

    int wt, val;

    Item(int w, int v) {
        wt = w;
        val = v;
    }

    @Override
    public int compareTo(Item i) {
        return wt * i.val - val * i.wt;
    }
}

public class FractionalKnapsack {

    public static void main(String a[]) {
        Item arr[] = {new Item(10, 60),
                new Item(40, 40),
                new Item(20, 100),
                new Item(30, 120)

        };
        int W = 50;
        System.out.print(fracKnapsack(arr, W));
    }

    private static double fracKnapsack(Item[] arr, int W) {
        Arrays.sort(arr); // sorted by val/wt descending due to compareTo
        double res = 0.0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].wt <= W) {
                res += arr[i].val;
                W -= arr[i].wt;
            } else {
                res += ((double) arr[i].val / arr[i].wt) * W;
                break;
            }
        }
        return res;
    }

}
