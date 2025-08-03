package ArraysL2;

import java.util.Arrays;

public class FindMinimumNumberOfArrowsNeededToBurstBalloon {
    public static int minArrows(int coordinates[][]) {
        // write your code here
        Arrays.sort(coordinates, (a, b) -> Integer.compare(a[1], b[1]));

        int arrow = 1, end = coordinates[0][1];

        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i][0] > end) {
                arrow++;
                end = coordinates[i][1];
            }
        }
        return arrow;
    }

    public static void main(String[] args) {
        int coordinates[][] = {
                {1, 3},
                {4, 5}
        };
        System.out.println(minArrows(coordinates));
    }
}
