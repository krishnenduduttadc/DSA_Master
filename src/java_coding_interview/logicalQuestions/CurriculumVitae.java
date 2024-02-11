package java_coding_interview.logicalQuestions;

public class CurriculumVitae {
    public static void main(String[] args) {
        int n = 6;
        int[] a = {0, 1, 0, 0, 1, 0};
        int ans = 0;
        int result = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] == 0) {
                    ans++;
                }
            }

            for (int j = i; j < n; j++) {
                if (a[j] == 1) {
                    ans++;
                }
            }
            result = Math.max(result, ans);
            ans = 0;
        }
        System.out.println(result);
    }
}
