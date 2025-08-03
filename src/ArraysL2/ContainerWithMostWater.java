package ArraysL2;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = mostwater(arr);
        System.out.println(res);
    }

    static int mostwater(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int water = 0;
        while (i < j) {
            int w = j - i;
            int h = Math.min(heights[i], heights[j]);
            water = Math.max(water, h * w);
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return water;
    }
}
