package CodeChef_java_coding_interview.logicalQuestions;

public class RemoveAllOccurrencesofaSubstring {
    public static void main(String[] args) {
        String s = "i lost life long ago life";
        String part = "life";
        String res = solve(s, part);
        System.out.println(res);
    }

    static String solve(String s, String part) {
        int L = part.length();
        while (1 == 1) {
            int idx = s.indexOf(part);
            if (idx > -1) {
                s = s.substring(0, idx) + s.substring(idx + L);
            } else {
                break;
            }
        }
        return s;
    }
}
