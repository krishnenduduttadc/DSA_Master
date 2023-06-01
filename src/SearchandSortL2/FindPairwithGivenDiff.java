package SearchandSortL2;

import java.util.Arrays;

public class FindPairwithGivenDiff {
    public static void main(String[] args) {
        int arr[] = {1, 7, 3, 10, 5, 6};
        findPair(arr,4);
    }

    static void findPair(int[] arr, int target) {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        while (i < arr.length && j < arr.length) {
            if (arr[j] - arr[i] == target) {
                System.out.println(arr[i] + " " + arr[j]);
                return;
            } else if (arr[j] - arr[i] < target) {
                j++;
            } else {
                i++;
            }
        }
        System.out.println("-1");

    }
}
