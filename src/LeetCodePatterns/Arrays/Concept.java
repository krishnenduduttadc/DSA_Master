package LeetCodePatterns.Arrays;

import java.util.Arrays;
import java.util.List;

public class Concept {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        int[] arr = new int[]{5, 4, 6, 1, 2, 3};
        Arrays.sort(arr, 2, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
