package GreedyL2;

import java.util.Arrays;

//Distribute candies to children based on ratings with minimum total candies.
public class CandyDistribution {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        int n = ratings.length;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int c : candies) sum += c;

        System.out.println("Minimum candies required = " + sum);
    }
}

