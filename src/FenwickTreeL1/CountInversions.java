package FenwickTreeL1;

import java.util.Arrays;

public class CountInversions {

    static int[] bit;
    static int n;

    static void update(int index, int val) {
        while (index <= n) {
            bit[index] += val;
            index += index & -index;
        }
    }

    static int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 1};
        int max = Arrays.stream(arr).max().getAsInt();

        n = max;
        bit = new int[n + 1];

        int inversions = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            inversions += query(arr[i] - 1);
            update(arr[i], 1);
        }

        System.out.println("Inversions: " + inversions); // 6
    }
}
