package java_coding_interview.logicalQuestions;

public class StringTyping {
    public static void main(String[] args) {
        int n = 7;
        String s = "ababcabc";
        int operations = n;
        int divided = n / 2;

        while (divided >= 2) {
            if (s.substring(0, divided).equals(s.substring(divided, divided + divided))) {
                operations = operations - divided + 1;
                break;
            }
            divided--;
        }

        System.out.println(operations);
    }
}
