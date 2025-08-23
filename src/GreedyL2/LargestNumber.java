package GreedyL2;

import java.util.Arrays;

//Arrange numbers to form the largest possible integer.
public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};

        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = String.valueOf(nums[i]);

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        if (arr[0].equals("0")) {
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);

        System.out.println("Largest number = " + sb.toString());
    }
}

