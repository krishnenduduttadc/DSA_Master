package CodingShuttle.DP;

public class LPS {
    public static void main(String[] args) {
        String a = "ABDCADB";
        System.out.println(longestPalindromicSubsequence(a));
    }

    static int longestPalindromicSubsequence(String s) {
        int n = s.length();
        char[] temp = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            temp[n - i - 1] = s.charAt(i);
        }
        String s2 = new String(temp);

        return lcsBottomUp(s, s2);
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
