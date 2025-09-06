package CodeChef_java_coding_interview.logicalQuestions;

import java.util.HashSet;

public class DetectiveBooks {
    public static void main(String[] args) {
        int n = 9;
        int[] a = {1, 3, 3, 6, 7, 6, 8, 8, 9};
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
            set.remove(i + 1);
            if (set.size() == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
