package HashMapAndHeap2;

import java.util.HashSet;

public class ArithmeticSequence {
    public static void main(String[] args) {
        int[] arr = {17, 9, 5, 29, 1, 25, 13, 37, 21, 33};
        System.out.println(sol(arr));

    }

    private static boolean sol(int[] arr) {
        if (arr.length <= 1) {
            return true;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();
        for (int val : arr) {
            min = Math.min(val, min);
            max = Math.max(val, max);
            set.add(val);
        }
        int d = (max - min) / (arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            int ai = min + i * d;
            if (set.contains(ai) == false) {
                return false;
            }
        }
        return true;
    }
}
