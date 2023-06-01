package ArraysL2;

public class MaxProductofThree {
    static int max(int[] arr) {
        int min1 = Integer.MAX_VALUE;
        int min2 = min1;
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        int max3 = max1;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (val > max1) {
                max3 = max2;
                max2 = max1;
                max1 = val;
            } else if (val >= max2) {
                max3 = max2;
                max2 = val;
            } else if (val >= max3) {
                max3 = val;
            }

            if (val <= min1) {
                min2 = min1;
                min1 = val;
            } else if (val <= min2) {
                min2 = val;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);

    }

    public static void main(String[] args) {
        int arr[]={2,4,6,7};
        int res=max(arr);
        System.out.println(res);
    }
}
