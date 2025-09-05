package LeetCodePatterns.BinarySearchOverRange;

import java.util.Arrays;

public class MagneticForceBetweenBalls {


    public static void main(String[] args) {
        MagneticForceBetweenBalls solver = new MagneticForceBetweenBalls();

        int[] pos1 = {1, 2, 3, 4, 7};
        int m1 = 3;
        System.out.println("Result 1: " + solver.maxDistance(pos1, m1)); // Expected 3

        int[] pos2 = {5, 4, 3, 2, 1, 1000000000};
        int m2 = 2;
        System.out.println("Result 2: " + solver.maxDistance(pos2, m2)); // Expected 999999999

        int[] pos3 = {1, 2};
        int m3 = 2;
        System.out.println("Result 3: " + solver.maxDistance(pos3, m3)); // Expected 1
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int start = 1;
        int end = position[n - 1] - position[0];

        int ans = 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isDistancePossible(position, m, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private boolean isDistancePossible(int[] position, int m, int dist) {
        int noOfBallsPlaced = 1;
        int lastPosition = position[0];

        for (int i = 1; i < position.length && noOfBallsPlaced < m; i++) {
            if (position[i] >= lastPosition + dist) {
                noOfBallsPlaced++;
                lastPosition = position[i];
            }
        }

        return noOfBallsPlaced >= m;
    }
}


