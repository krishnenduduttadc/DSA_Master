package CodeChef_java_coding_interview.logicalQuestions;

public class StripeCutting {
    static int n, m, k;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = 9;
        int[] a = {1, 5, -6, 7, 9, -16, 0, -2, 2};
        int s = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            s += a[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            left += a[i];
            if (left == (s - left)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
