package CodeChef_java_coding_interview.logicalQuestions;

public class MonstersBattleRoyale {
    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        int[] a = {2, 10, 8, 40};
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer = gcd(answer, a[i]);
        }
        System.out.println(answer);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
