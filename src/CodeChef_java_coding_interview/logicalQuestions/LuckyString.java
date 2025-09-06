package CodeChef_java_coding_interview.logicalQuestions;

public class LuckyString {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int n = 16;
        char[] cs = {'a', 'b', 'c', 'd'};
        char[] ans = new char[n];
        for (int i = 0; i < Math.min(n, 4); i++) {
            for (int j = i; j < n; j = j + 4) {
                ans[j] = cs[i];
            }
        }
        String res = new String(ans);
        System.out.println(res);

    }
}
