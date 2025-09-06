package CodeChef_java_coding_interview.logicalQuestions;

public class SwapAdjacentElements {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int n = 6;
        int[] arr = {1, 5, 2, 3, 4, 6};
        String p = "01110";
        boolean flag = false;
        int max = 0;


        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, arr[i]);
            if (p.charAt(i) == '0' && max > i + 1) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
