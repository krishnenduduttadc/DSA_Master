package java_coding_interview.logicalQuestions;

public class CircleMetro {
    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        int n = 5;
        int a = 1;
        int x = 4;
        int b = 3;
        int y = 2;

        while (!(a == x || b == y)) {
            a++;
            a = a % n;
            b--;
            b += n;
            b = b % n;

            if (a == b) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
