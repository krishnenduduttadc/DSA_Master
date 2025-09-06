package CodeChef_java_coding_interview.logicalQuestions;

import java.util.Arrays;

public class WrongAnswer {
    public static void main(String[] args) {
        String s1 = "310";
        String s2 = "103";
        char[] c = s1.toCharArray();
        Arrays.sort(c);

        if (c[0] == '0') {
            c[0] = c[1];
            c[1] = '0';
        }
        s1 = new String(c);

        if (s1.equals(s2)) {
            System.out.println("AC");
        } else {
            System.out.println("WA");
        }
    }
}
