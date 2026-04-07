package RecursionAndBacktrackingL3;

public class BeautifulArrangement {


    static int count = 0;

    public static void main(String[] args) {

        int n = 3;
        boolean[] used = new boolean[n + 1];

        backtrack(n, 1, used);

        System.out.println(count);
    }

    public static void backtrack(int n, int pos, boolean[] used) {

        if (pos > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (!used[i] && (i % pos == 0 || pos % i == 0)) {

                used[i] = true;

                backtrack(n, pos + 1, used);

                used[i] = false;
            }
        }
    }

}
