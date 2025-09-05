package LeetCodePatterns.Arrays;

import java.util.Arrays;
import java.util.Random;

public class KclosestPointsToOrigin {

    public static void main(String[] args) {
        KclosestPointsToOrigin solution = new KclosestPointsToOrigin();

        int[][] points1 = {{1, 3}, {-2, 2}};
        int k1 = 1;
        System.out.println("Closest " + k1 + " points: " +
                Arrays.deepToString(solution.kClosest(points1, k1)));
        // Expected: [[-2, 2]]
    }

    public int[][] kClosest(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        while (left <= right) {
            int pivotIndex = partition(points, left, right);
            if (pivotIndex == k - 1) {
                break;
            } else if (pivotIndex < k - 1) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }

        return result;
    }

    private int partition(int[][] points, int left, int right) {
        int pivotIndex = left + new Random().nextInt(right - left + 1);
        int[] pivotPoint = points[pivotIndex];
        swap(points, pivotIndex, right);

        int i = left;
        for (int j = left; j < right; j++) {
            if (compare(points[j], pivotPoint) < 0) {
                swap(points, i++, j);
            }
        }
        swap(points, i, right);
        return i;
    }

    private int compare(int[] point1, int[] point2) {
        return (point1[0] * point1[0] + point1[1] * point1[1]) -
                (point2[0] * point2[0] + point2[1] * point2[1]);
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
