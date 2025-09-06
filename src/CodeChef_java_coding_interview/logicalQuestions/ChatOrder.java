package CodeChef_java_coding_interview.logicalQuestions;

import java.util.LinkedHashSet;

public class ChatOrder {
    public static void main(String[] args) {

        int n = 4;

        String[] a = {"alex", "ivan", "roman", "ivan"};

        LinkedHashSet<String> s = new LinkedHashSet<>();


        for (int i = n - 1; i >= 0; i--) {
            s.add(a[i]);
        }

        System.out.println("");

        Object[] p = s.toArray();

        for (int i = 0; i < p.length; i++) {
            System.out.println((String) p[i]);
        }
    }
}
