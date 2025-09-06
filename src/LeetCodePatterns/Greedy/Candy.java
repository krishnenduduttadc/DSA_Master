package LeetCodePatterns.Greedy;

public class Candy {

    static int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for (int i = 0; i < candy.length; i++) {
            candy[i] = 1;
        }


        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
        }

        int totalcandies = 0;
        for (int i = 0; i < candy.length; i++) {
            totalcandies += candy[i];
        }
        return totalcandies;
    }


    public static void main(String[] args) {
        int[] ratings1 = {1, 0, 2};
        int[] ratings2 = {1, 2, 2};
        int[] ratings3 = {1, 3, 4, 5, 2};

        System.out.println("Ratings: [1,0,2] -> Minimum Candies: " + candy(ratings1));
        System.out.println("Ratings: [1,2,2] -> Minimum Candies: " + candy(ratings2));
        System.out.println("Ratings: [1,3,4,5,2] -> Minimum Candies: " + candy(ratings3));
    }
}
