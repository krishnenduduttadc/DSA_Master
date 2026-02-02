package CodingShuttle.DP;

public class SCS {
    public static void main(String[] args) {
        String a = "ABDCADB";
        String b = "AECB";
        System.out.println(minLengthSuperSequence(a, b));
    }

    static int minLengthSuperSequence(String s1, String s2) {
        int lcs = lcsBottomUp(s1, s2);
        return s1.length() + s2.length() - lcs;
    }

    static int lcsBottomUp(String a, String b) {
        int m = a.length();
        int n = b.length();

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

            System.arraycopy(arr2, 0, arr1, 0, n + 1);
        }

        return arr2[n];
    }
}
