package CodingShuttle.Backtracking;

import java.util.ArrayList;

public class PermutationOfArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        ArrayList<int[]> ans = new ArrayList<>();

        permute(a, 0, a.length - 1, ans);

        System.out.println("printing the ans array");

        for (int[] arr : ans) {
            printArray(arr);
        }
    }

    static void permute(int[] a, int l, int r, ArrayList<int[]> ans) {
        if (l == r) {
            printArray(a);
            int[] b = new int[a.length];
            System.arraycopy(a, 0, b, 0, a.length);
            ans.add(b);
            return;
        }
        for (int i = l; i <= r; i++) {
            swap(a, i, l);
            permute(a, l + 1, r, ans);
            swap(a, i, l); //Backtracking
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void printArray(int[] a) {
        for (int e : a) {
            System.out.print(e);
        }
        System.out.println();
    }
}
