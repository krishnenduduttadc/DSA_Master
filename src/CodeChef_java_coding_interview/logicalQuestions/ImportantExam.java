package CodeChef_java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class ImportantExam {
    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        int n = 2;
        int m = 4;
        String[] ar = {"ABCD", "ABCE"};
        String s = "1 2 3 4";
        String[] arr = s.split(" ");
        int[] freq = new int[26];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                freq[ar[j].charAt(i) - 'A']++;
            }
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 26; j++) {
                if (freq[j] > max) {
                    max = freq[j];
                }
            }


            count += max * Integer.parseInt(arr[i]);
            Arrays.fill(freq, 0);
        }
        System.out.println(count);
    }
}
