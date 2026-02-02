package CodingShuttle.DP;

public class LCSSpaceOptimization {

    public static void main(String[] args) {
        String a = "ABDCADB";
        String b = "AECB";

        System.out.println(lcsBottomUp(a, b));
    }

    static int lcsBottomUp(String a, String b) {
        int m = a.length();
        int n = b.length();

        // Space optimized DP arrays
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    arr2[j] = arr1[j - 1] + 1;
                } else {
                    arr2[j] = Math.max(arr1[j], arr2[j - 1]);
                }
            }

            // Copy arr2 to arr1 for the next iteration
            System.arraycopy(arr2, 0, arr1, 0, n + 1);
        }

        return arr2[n];
    }
}
