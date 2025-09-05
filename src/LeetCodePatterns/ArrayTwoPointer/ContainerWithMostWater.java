package LeetCodePatterns.ArrayTwoPointer;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        // Expected: 49
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;

        while (left < right) {
            int heightOfContainer = Math.min(height[left], height[right]);
            int width = right - left;

            int area = heightOfContainer * width;

            if (area > ans) {
                ans = area;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}
