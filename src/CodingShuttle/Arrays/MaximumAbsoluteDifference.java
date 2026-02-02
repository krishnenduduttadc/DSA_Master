package CodingShuttle.Arrays;

public class MaximumAbsoluteDifference {
    public static void main(String[] args) {
        int[] a = {12, 9, 8, 2, 11, 5, 4, 5};

        System.out.println(maximumDiff(a));
    }

    static int maximumDiff(int[] a) {
        int n = a.length;

        int minaipi = Integer.MAX_VALUE;
        int maxaipi = Integer.MIN_VALUE;

        int minaimi = Integer.MAX_VALUE;
        int maxaimi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            minaipi = Math.min(minaipi, a[i] + i);
            maxaipi = Math.max(maxaipi, a[i] + i);

            minaimi = Math.min(minaimi, a[i] - i);
            maxaimi = Math.max(maxaimi, a[i] - i);
        }

        int diffaipi = maxaipi - minaipi;
        int diffaimi = maxaimi - minaimi;

        return Math.max(diffaipi, diffaimi);
    }
}
