package CodingShuttle.Arrays;

import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {
        int[] a = {6, 1, 2, 9, 4, 7};

        waveArray(a);

        printArray(a);
    }

    static void waveArray(int[] a) {
        Arrays.sort(a); // O(nlog n)
        int n = a.length;
        for (int i = 1; i < n; i += 2) {
            swap(a, i, i - 1);
        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void printArray(int[] a) {
        for (int e : a) {
            System.out.print(e + " ");
        }
    }
}
