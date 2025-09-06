package CodeChef_java_coding_interview.logicalQuestions;

public class OmkaarAndWaterSlide {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int n = 4;
        int total_operations_required = 0;
        int[] arr = {5, 3, 2, 5};
        for (int i = 0; i < n - 1; i++) {
            total_operations_required += Math.max(0, arr[i] - arr[i + 1]);
        }
        System.out.println(total_operations_required);
    }
}
