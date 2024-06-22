package TwoPointer;

import RecursionAndBacktrackingL1.Solution;

public class ContainerMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (i < j) {
            int w = (j - i) * Math.min(height[i], height[j]);
            ans = Math.max(ans, w);
            if (height[i] <= height[j]) i++;
            else j--;
        }
        return ans;
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        ContainerMostWater solution = new ContainerMostWater();

        // Hardcoded input array
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7}; // Example input

        // Calling maxArea to find the maximum area of water that can be contained
        int maxWater = solution.maxArea(height);

        // Printing the maximum area
        System.out.println("Maximum area of water: " + maxWater);
    }
}
