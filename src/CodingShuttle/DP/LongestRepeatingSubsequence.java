package CodingShuttle.DP;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String a = "ABDCADB";

        System.out.println(longestRepeatingSubsequence(a));
    }

    static int longestRepeatingSubsequence(String a) {
        int m = a.length();
        int n = m;

        String b = a;

        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1) && i - 1 != j - 1) {
                    arr2[j] = arr1[j - 1] + 1;
                } else {
                    arr2[j] = Math.max(arr1[j], arr2[j - 1]);
                }
            }

            System.arraycopy(arr2, 0, arr1, 0, n + 1);
        }

        return arr2[n];
    }
}
